package uplord.uplordapi.sysManange.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uplord.uplordapi.common.exception.NoCreatedDataException;
import uplord.uplordapi.common.exception.NoUpdatedDataException;
import uplord.uplordapi.sysManange.dao.CommonCodeDAO;
import uplord.uplordapi.sysManange.service.CommonCodeService;
import uplord.uplordapi.sysManange.vo.CommonCodeVO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommonCodeServiceImpl implements CommonCodeService {

    private final CommonCodeDAO dao;

    @Override
    public List<CommonCodeVO> findList(CommonCodeVO param) {
        return dao.findList(param);
    }

    @Override
    public void create(CommonCodeVO param) {
        int result = dao.create(param);

        if (result == 0) {
            throw new NoCreatedDataException();
        }
    }

    @Override
    public void update(CommonCodeVO param) {
        int result = dao.update(param);

        if (result == 0) {
            throw new NoUpdatedDataException();
        }
    }
}
