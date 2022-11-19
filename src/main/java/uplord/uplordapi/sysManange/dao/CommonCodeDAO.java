package uplord.uplordapi.sysManange.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import uplord.uplordapi.sysManange.dto.CommonCodeDTO;
import uplord.uplordapi.sysManange.dto.CommonDetailCodeDTO;

import java.util.List;

@Mapper
@Repository
public interface CommonCodeDAO {

    List<CommonCodeDTO> findHirCodeList(CommonCodeDTO param);

    List<CommonDetailCodeDTO> findDetailCodeList(CommonDetailCodeDTO param);

    int hirCodeCreate(CommonCodeDTO param);

    int hirCodeUpdate(CommonCodeDTO param);

    int detailCodeCreate(CommonDetailCodeDTO param);

    int detailCodeUpdate(CommonDetailCodeDTO param);
}
