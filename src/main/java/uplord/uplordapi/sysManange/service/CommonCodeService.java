package uplord.uplordapi.sysManange.service;

import uplord.uplordapi.sysManange.vo.CommonCodeVO;

import java.util.List;

public interface CommonCodeService {
    List<CommonCodeVO> findList(CommonCodeVO param);

    void create(CommonCodeVO param);

    void update(CommonCodeVO param);
}
