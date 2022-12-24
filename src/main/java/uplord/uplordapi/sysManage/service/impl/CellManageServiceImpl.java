package uplord.uplordapi.sysManage.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uplord.uplordapi.common.exception.NoCreatedDataException;
import uplord.uplordapi.common.exception.NoUpdatedDataException;
import uplord.uplordapi.sysManage.dao.CellManageDAO;
import uplord.uplordapi.sysManage.service.CellManageService;
import uplord.uplordapi.dto.CellDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CellManageServiceImpl implements CellManageService {

    private final CellManageDAO dao;

    @Override
    public List<CellDTO> findList(CellDTO param) {
        return dao.findList(param);
    }

    @Override
    public void update(CellDTO param) {
        int result = dao.update(param);

        if (result == 0) {
            throw new NoCreatedDataException();
        }


    }

    @Override
    public void create(CellDTO param) {
        int result = dao.create(param);

        if (result == 0) {
            throw new NoUpdatedDataException();
        }
    }
}
