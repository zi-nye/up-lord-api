package uplord.uplordapi.sysManage.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import uplord.uplordapi.dto.LoginHistoryDTO;

import java.util.List;

@Mapper
@Repository
public interface LoginHistoryDAO {
    List<LoginHistoryDTO> findLoginHistoryList(LoginHistoryDTO param);
}
