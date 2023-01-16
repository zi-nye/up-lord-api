package uplord.uplordapi.sysManage.service;

import uplord.uplordapi.dto.LoginHistoryDTO;

import java.util.List;

public interface LoginHistoryService {
    List<LoginHistoryDTO> findLoginHistoryList(LoginHistoryDTO param);
}
