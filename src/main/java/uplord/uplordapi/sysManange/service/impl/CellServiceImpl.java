package uplord.uplordapi.sysManange.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uplord.uplordapi.sysManange.dao.CellDAO;
import uplord.uplordapi.sysManange.service.CellService;
import uplord.uplordapi.sysManange.vo.CellVO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CellServiceImpl implements CellService {

    private CellDAO dao;

    @Override
    public List<CellVO> findList(CellVO param) {
        List<CellVO> clist = dao.findList(param);
        System.out.println(clist.get(0).getCellCd());
        return dao.findList(param);
    }
}
