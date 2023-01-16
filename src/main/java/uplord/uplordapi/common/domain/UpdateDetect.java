package uplord.uplordapi.common.domain;
/**
 * 이 인터페이스를 구현한 VO가 insert, update 쿼리의 파라미터로 사용된다면 변경된 테이블의 공통 칼럼이 저장됩니다.
 * insert 시, 생성일자, 생성자 IP, 생성자 UID, 수정일자, 수정자 IP, 수정자 UID가 저장되며,
 * update 시, 수정일자, 수정자 IP, 수정자 UID가 갱신됩니다.
 *
 * 현재는 단일 Row 저장만 고려되어 있으므로
 * 다중 Row 저장의 경우 기능을 추가하거나 수동으로 처리해야 합니다.
 */
public interface UpdateDetect {
}
