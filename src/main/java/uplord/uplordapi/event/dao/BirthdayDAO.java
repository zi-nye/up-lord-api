package uplord.uplordapi.event.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import uplord.uplordapi.dto.MemberInfoDTO;

import java.util.List;
@Mapper
@Repository
public interface BirthdayDAO {
    public List<MemberInfoDTO> findList();

}
