package uplord.uplordapi.sysManange.service;
import uplord.uplordapi.sysManange.dto.CellDTO;

import java.util.List;

public interface CellService {
    List<CellDTO> findList(CellDTO param);

    void update(CellDTO param);

    void create(CellDTO param);
}
