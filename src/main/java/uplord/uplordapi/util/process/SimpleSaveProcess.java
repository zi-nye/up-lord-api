package uplord.uplordapi.util.process;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @param <T> KeyGenerator를 구현한 객체입니다.
 *            KeyObject를 반환하는 generateKey 메서드가 존재해야하며
 *            해당 KeyObject에 담긴 데이터를 비교하여 insert 할지 update할 지 결정하기 때문에
 *            generateKey 메서드가 반환하는 KeyObject는 키값을 온전히 가지고 있어야 합니다.
 */
public class SimpleSaveProcess<T extends KeyGenerator> {

    /**
     * 동일한 키를 가진 데이터가 존재하면 update, 없으면 insert하는 로직을 간단하게 작성합니다.
     * 오라클의 MERGE문 같은 역할.
     * 다만 MERGE문은 개발 속도는 조금 빠르지만 디버깅도 불편하고 유지보수성이 떨어지기 떄문에 사용하지 않습니다.
     *
     * @param dataList          저장할 데이터 리스트.
     * @param targetDataList    저장할 테이블에서 가져온 데이터 리스트. (새로 저장되는 데이터와 비교하기 위한 기존 데이터)
     * @param createHandler     insert interface
     * @param updateHandler     update 메서드. 첫 번째 인자로 전달되는 객체(from dataList)에 값이 변경된 필드가 존재하는지 여부를
     *                          기존 데이터(targetDataList)를 기준으로 검색하여 두번째 인자로 전달해줍니다.
     * @param changeDataHandler 반복문 도중 값이 변경된 데이터가 발견될 때마다 실행되는 훅 메서드입니다.
     *                          값의 비교는 KeyGenerator의 equals, hashCode를 이용하여 수행됩니다.
     *                          equals, hashCode의 구현은 ide의 자동 완성 기능을 이용하는 것을 권장합니다.
     */
    public SaveResult forEachSave(List<T> dataList, List<T> targetDataList, Function<T, Integer> createHandler,
                                  BiFunction<T, Boolean, Integer> updateHandler, Consumer<T> changeDataHandler) {
        List<KeyObject> keyList = targetDataList.stream().map(KeyGenerator::generateKey).collect(Collectors.toList());

        int createdCount = 0;
        int updatedCount = 0;

        boolean exists;
        boolean existsChangeField;
        for (T data : dataList) {
            exists = keyList.contains(data.generateKey());
            if (exists) {
                existsChangeField = isNotEquals(targetDataList, data);
                if (existsChangeField) {
                    executeChangeDataHandler(changeDataHandler, data);
                }
                updatedCount += updateHandler.apply(data, existsChangeField);
            } else {
                executeChangeDataHandler(changeDataHandler, data);
                createdCount += createHandler.apply(data);
            }
        }

        return SaveResult.builder()
                .createdCount(createdCount)
                .updatedCount(updatedCount)
                .totalCount(createdCount + updatedCount)
                .build();
    }

    public SaveResult forEachSave(List<T> dataList, List<T> targetDataList, Function<T, Integer> createHandler,
                                  Function<T, Integer> updateHandler, Consumer<T> changeDataHandler) {
        return forEachSave(dataList, targetDataList, createHandler, (t, existsChangeData) -> updateHandler.apply(t), changeDataHandler);
    }

    public SaveResult forEachSave(List<T> dataList, List<T> targetDataList, Function<T, Integer> createHandler,
                                  BiFunction<T, Boolean, Integer> updateHandler) {
        return forEachSave(dataList, targetDataList, createHandler, updateHandler, null);
    }

    public SaveResult forEachSave(List<T> dataList, List<T> targetDataList, Function<T, Integer> createHandler,
                                  Function<T, Integer> updateHandler) {
        return forEachSave(dataList, targetDataList, createHandler, (t, existsChangeData) -> updateHandler.apply(t), null);
    }

    private void executeChangeDataHandler(Consumer<T> handler, T data) {
        if (handler == null) {
            return;
        }
        handler.accept(data);
    }

    private boolean isNotEquals(List<T> list, T compareTarget) {
        return list.stream().noneMatch(t -> t.equals(compareTarget));
    }

}