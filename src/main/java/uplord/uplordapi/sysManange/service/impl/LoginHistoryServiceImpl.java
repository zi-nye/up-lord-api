package uplord.uplordapi.sysManange.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uplord.uplordapi.dto.LoginHistoryDTO;
import uplord.uplordapi.sysManange.dao.LoginHistoryDAO;
import uplord.uplordapi.sysManange.service.LoginHistoryService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginHistoryServiceImpl implements LoginHistoryService {
    private final LoginHistoryDAO dao;

    @Override
    public List<LoginHistoryDTO> findLoginHistoryList(LoginHistoryDTO param) {
        return dao.findLoginHistoryList(param);
    }

}
