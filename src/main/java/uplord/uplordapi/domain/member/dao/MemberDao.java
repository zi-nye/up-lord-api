package uplord.uplordapi.domain.member.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MemberDao {
    List<Long> findAllMemberIdx();
}
