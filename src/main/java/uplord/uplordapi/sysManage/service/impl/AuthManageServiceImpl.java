package uplord.uplordapi.sysManage.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uplord.uplordapi.common.exception.NoCreatedDataException;
import uplord.uplordapi.common.exception.NoDeletedDataException;
import uplord.uplordapi.common.exception.NoUpdatedDataException;
import uplord.uplordapi.sysManage.dao.AuthManageDAO;
import uplord.uplordapi.sysManage.service.AuthManageService;
import uplord.uplordapi.dto.AuthDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthManageServiceImpl implements AuthManageService {

    private final AuthManageDAO dao;

    @Override
    public List<AuthDTO> findAllAthList(AuthDTO param) {
        return dao.findAuthList(param);
    }

    @Override
    public void create(AuthDTO param) {
        int result = 0;

        for (AuthDTO item : param.getAddedRowItems()) {
            result += dao.create(item);
        }
        if (result == 0) {
            throw new NoCreatedDataException();
        }
    }

    @Override
    public void update(AuthDTO param) {
        int result = 0;

        for (AuthDTO item : param.getEditedRowItems()) {
            result += dao.update(item);
        }
        if (result == 0) {
            throw new NoUpdatedDataException();
        }
    }

    @Override
    public void createAthGp(AuthDTO param) {
        int result = 1;
        List<AuthDTO> vos = dao.findAthGpList(param);

        for (AuthDTO item : param.getAddedRowItems()) {
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
    public void deleteAthGp(AuthDTO param) {
        int result = 1;

        for (AuthDTO item : param.getRemovedRowItems()) {
            result *= dao.deleteAthGp(item);
        }

        if (result == 0) {
            throw new NoDeletedDataException();
        }
    }

    @Override
    public List<AuthDTO> findNotAthGpList(AuthDTO param) {
        return dao.findNotAthGpList(param);
    }

    @Override
    public List<AuthDTO> findAthGpList(AuthDTO param) {
        return dao.findAthGpList(param);
    }
}
