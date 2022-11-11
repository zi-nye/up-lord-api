package uplord.uplordapi.sysManange.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uplord.uplordapi.common.exception.NoCreatedDataException;
import uplord.uplordapi.common.exception.NoDeletedDataException;
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
    public List<AuthVO> findAllAthList(AuthVO param) {
        return dao.findAuthList(param);
    }

    @Override
    public void create(AuthVO param) {
        int result = 0;

        for (AuthVO item : param.getAddedRowItems()) {
            result += dao.create(item);
        }
        if (result == 0) {
            throw new NoCreatedDataException();
        }
    }

    @Override
    public void update(AuthVO param) {
        int result = 0;

        for (AuthVO item : param.getEditedRowItems()) {
            result += dao.update(item);
        }
        if (result == 0) {
            throw new NoUpdatedDataException();
        }
    }

    @Override
    public void createAthGp(AuthVO param) {
        int result = 1;
        List<AuthVO> vos = dao.findAthGpList(param);

        for (AuthVO item : param.getAddedRowItems()) {
            if (vos.contains(item)) {
                continue;
            }
            result *= dao.createAthGp(item);
        }

        if (result == 0) {
            throw new NoCreatedDataException();
        }
    }

    @Override
    public void deleteAthGp(AuthVO param) {
        int result = 1;

        for (AuthVO item : param.getRemovedRowItems()) {
            result *= dao.deleteAthGp(item);
        }

        if (result == 0) {
            throw new NoDeletedDataException();
        }
    }

    @Override
    public List<AuthVO> findNotAthGpList(AuthVO param) {
        return dao.findNotAthGpList(param);
    }

    @Override
    public List<AuthVO> findAthGpList(AuthVO param) {
        return dao.findAthGpList(param);
    }
}
