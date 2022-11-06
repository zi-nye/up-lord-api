package uplord.uplordapi.sysManange.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uplord.uplordapi.common.exception.NoCreatedDataException;
import uplord.uplordapi.common.exception.NoUpdatedDataException;
import uplord.uplordapi.sysManange.dao.AuthDAO;
import uplord.uplordapi.sysManange.service.AuthService;
import uplord.uplordapi.sysManange.vo.AuthVO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthDAO dao;

    @Override
    public List<AuthVO> findList(AuthVO param) {
        return dao.findList(param);
    }

    @Override
    public void create(AuthVO param) {
        int result = dao.create(param);

        if (result == 0) {
            throw new NoCreatedDataException();
        }
    }

    @Override
    public void update(AuthVO param) {
        int result = dao.update(param);

        if (result == 0) {
            throw new NoUpdatedDataException();
        }
    }
}
