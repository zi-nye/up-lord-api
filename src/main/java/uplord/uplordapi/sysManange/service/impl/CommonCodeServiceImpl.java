package uplord.uplordapi.sysManange.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uplord.uplordapi.common.exception.NoCreatedDataException;
import uplord.uplordapi.common.exception.NoUpdatedDataException;
import uplord.uplordapi.sysManange.dao.CommonCodeDAO;
import uplord.uplordapi.sysManange.dto.CommonDetailCodeDTO;
import uplord.uplordapi.sysManange.service.CommonCodeService;
import uplord.uplordapi.sysManange.dto.CommonCodeDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommonCodeServiceImpl implements CommonCodeService {

    private final CommonCodeDAO dao;

    @Override
    public List<CommonCodeDTO> findHirCodeList(CommonCodeDTO param) {
        return dao.findHirCodeList(param);
    }

    @Override
    public List<CommonDetailCodeDTO> findDetailCodeList(CommonDetailCodeDTO param) {
        return dao.findDetailCodeList(param);
    }

    @Override
    public void hirCodeCreate(CommonCodeDTO param) {
        int result = dao.hirCodeCreate(param);

        if (result == 0) {
            throw new NoCreatedDataException();
        }
    }

    @Override
    public void detailCodeUpdate(CommonDetailCodeDTO param) {
        int result = dao.detailCodeUpdate(param);

        if (result == 0) {
            throw new NoUpdatedDataException();
        }
    }

    @Override
    public void detailCodeCreate(CommonDetailCodeDTO param) {
        int result = dao.detailCodeCreate(param);

        if (result == 0) {
            throw new NoUpdatedDataException();
        }
    }

    @Override
    public void hirCodeUpdate(CommonCodeDTO param) {
        int result = dao.hirCodeUpdate(param);

        if (result == 0) {
            throw new NoUpdatedDataException();
        }
    }

}
