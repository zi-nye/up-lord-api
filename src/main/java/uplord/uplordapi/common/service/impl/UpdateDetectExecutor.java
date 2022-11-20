package uplord.uplordapi.common.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import uplord.uplordapi.common.dao.UpdateDetectDAO;
import uplord.uplordapi.common.vo.UpdateDetectVO;
import uplord.uplordapi.oauth.domain.Token;
import uplord.uplordapi.oauth.service.TokenHttpResolver;
import uplord.uplordapi.oauth.service.impl.HttpHelper;
import uplord.uplordapi.oauth.service.impl.JwtResolver;
import uplord.uplordapi.util.ThreadUtil;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UpdateDetectExecutor {

    @Value("${spring.datasource.username}")
    private String owner;

    private final Map<String, List<String>> keyNamesFactory = new HashMap<>();

    private final UpdateDetectDAO detectDao;
    private final TokenHttpResolver tokenHttpResolver;
    private final JwtResolver jwtResolver;

    public void execute(SqlCommandType commandType, String sql, Object arg) {
        String pointToken = getPointToken(commandType);
        String tableName = getTableName(sql, pointToken);
        List<String> keyNames = getKeyColumnNames(tableName);
        String conditionClause = makeConditionClause(arg, keyNames);

        if (conditionClause == null) {
            return;
        }

        int result = 0;
        if (isInsert(commandType) && isExistsCreateColumns(tableName)) {
            result = detectDao.updateDetectedColumnsByInsertCommand(makeInsertParam(tableName, conditionClause));
        }
        else if (isUpdate(commandType) && isExistsUpdateColumns(tableName)) {
            result = detectDao.updateDetectedColumnsByUpdateCommand(makeUpdateParam(tableName, conditionClause));
        }

        if (result == 0) {
            log.error(
                    "[{}] No updated detected common columns. tableName: {}, conditionClause: {}",
                    ThreadUtil.getCurrentMethodName(),
                    tableName,
                    conditionClause
            );
        }
    };

    private boolean isExistsCreateColumns(String tableName) {
        return detectDao.isExistsCreateColumns(makeCheckParam(tableName));
    }

    private boolean isExistsUpdateColumns(String tableName) {
        return detectDao.isExistsUpdateColumns(makeCheckParam(tableName));
    }

    private String getPointToken(SqlCommandType commandType) {
        if (isInsert(commandType)) {
            return "INTO";
        }
        if (isUpdate(commandType)) {
            return "UPDATE";
        }
        return null;
    }

    private String getTableName(String sql, String pointToken) {
        int pointTokenIndex = sql.toUpperCase().indexOf(pointToken);
        String[] tokens = sql.substring(pointTokenIndex).replaceAll("\\s+", " ").split(" ");
        return tokens[1].replaceAll("[(]", "");
    }

    private List<String> getKeyColumnNames(String tableName) {
        if (keyNamesFactory.containsKey(tableName)) {
            return keyNamesFactory.get(tableName);
        }

        UpdateDetectVO param = UpdateDetectVO.builder()
                .owner(owner)
                .tableName(tableName)
                .build();
        List<String> keyNames = detectDao.findPrimaryKeyColumnNames(param);
        keyNamesFactory.put(tableName, keyNames);
        return keyNames;
    }

    private String makeConditionClause(Object arg, List<String> keyNames) {
        Map<String, Object> argMap = toMap(arg);
        List<String> keyNamesInArg = keyNames.stream()
                .filter(s -> argMap.containsKey(snakeToCamel(s)))
                .collect(Collectors.toList());

        if (keyNames.size() != keyNamesInArg.size()) {
            log.error(
                    "[{}] Not matched count that PK column. key count of table: {}, but key count of update query argument: {}",
                    ThreadUtil.getCurrentMethodName(),
                    keyNames.size(),
                    keyNamesInArg.size()
            );
            return null;
        }

        return keyNames.stream()
                .map(s -> s + "='" + argMap.get(snakeToCamel(s)) + "'")
                .collect(Collectors.joining(" AND "));
    }

    private UpdateDetectVO makeCheckParam(String tableName) {
        return UpdateDetectVO.builder()
                .owner(owner)
                .tableName(tableName)
                .build();
    }

    private UpdateDetectVO makeInsertParam(String tableName, String conditionClause) {
        return UpdateDetectVO.builder()
                .owner(owner)
                .tableName(tableName)
                .conditionClause(conditionClause)
                .crtUid(getUserId())
                .crtIp(getClientIp())
                .udtUid(getUserId())
                .udtIp(getClientIp())
                .build();
    }

    private UpdateDetectVO makeUpdateParam(String tableName, String conditionClause) {
        return UpdateDetectVO.builder()
                .owner(owner)
                .tableName(tableName)
                .conditionClause(conditionClause)
                .udtIp(getClientIp())
                .udtUid(getUserId())
                .build();
    }

    private Map<String, Object> toMap(Object arg) {
        Map<String, Object> map = new HashMap<>();
        try {
            for (Field field : arg.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                map.put(field.getName(), field.get(arg));
            }
        } catch (IllegalAccessException ignored) {}
        return map;
    }

    private String snakeToCamel(String str) {
        String[] fragments = str.toLowerCase().split("_");
        return fragments[0] + Arrays.stream(Arrays.copyOfRange(fragments, 1, fragments.length))
                .map(s -> Strings.isEmpty(s) ? s : s.substring(0, 1).toUpperCase() + s.substring(1))
                .collect(Collectors.joining());
    }

    private String getClientIp() {
        return HttpHelper.getClientIp();
    }

    private String getUserId() {
        Token token = tokenHttpResolver.getAccessToken();
        return jwtResolver.getUserId(token.getJwt());
    }

    private boolean isInsert(SqlCommandType commandType) {
        return SqlCommandType.INSERT == commandType;
    }

    private boolean isUpdate(SqlCommandType commandType) {
        return SqlCommandType.UPDATE == commandType;
    }

}