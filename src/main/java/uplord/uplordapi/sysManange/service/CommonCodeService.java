package uplord.uplordapi.sysManange.service;

import uplord.uplordapi.dto.CommonCodeDTO;
import uplord.uplordapi.dto.CommonDetailCodeDTO;

import java.util.List;

public interface CommonCodeService {
    List<CommonCodeDTO> findHirCodeList(CommonCodeDTO param);

    List<CommonDetailCodeDTO> findDetailCodeList(CommonDetailCodeDTO param);

    void hirCodeCreate(CommonCodeDTO param);

    void detailCodeUpdate(CommonDetailCodeDTO param);

    void hirCodeUpdate(CommonCodeDTO param);

    void detailCodeCreate(CommonDetailCodeDTO param);
}
