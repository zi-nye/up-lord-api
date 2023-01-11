package uplord.uplordapi.sysManange.service;

import uplord.uplordapi.dto.LoginHistoryDTO;

import java.util.List;

public interface LoginHistoryService {
    List<LoginHistoryDTO> findLoginHistoryList(LoginHistoryDTO param);
}
