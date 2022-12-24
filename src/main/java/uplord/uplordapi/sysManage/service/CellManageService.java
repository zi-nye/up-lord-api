package uplord.uplordapi.sysManage.service;
import uplord.uplordapi.dto.CellDTO;

import java.util.List;

public interface CellManageService {
    List<CellDTO> findList(CellDTO param);

    void update(CellDTO param);

    void create(CellDTO param);
}
