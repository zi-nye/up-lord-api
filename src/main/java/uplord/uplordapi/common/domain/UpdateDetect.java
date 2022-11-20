package uplord.uplordapi.common.domain;

/**
 * 이 인터페이스를 구현한 VO가 insert, update 쿼리의 파라미터로 사용된다면 변경된 테이블의 공통 칼럼이 저장됩니다.
 * insert 시, 생성일자, 생성자 IP, 생성자 UID, 수정일자, 수정자 IP, 수정자 UID가 저장되며,
 * update 시, 수정일자, 수정자 IP, 수정자 UID가 갱신됩니다.
 *
 * @see  만약 이 인터페이스가 적용된 VO를 파라미터로 사용하여 저장한 테이블에
 * 공통 컬럼이 존재하지 않는다면 에러가 발생합니다.
 */
public interface UpdateDetect {
}
