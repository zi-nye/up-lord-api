package uplord.uplordapi.sysManange.service;
import uplord.uplordapi.sysManange.vo.CellVO;

import java.util.List;

public interface CellService {
    List<CellVO> findList(CellVO param);
}
