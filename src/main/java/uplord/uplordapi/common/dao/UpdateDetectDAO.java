package uplord.uplordapi.common.dao;

import org.apache.ibatis.annotations.Mapper;
import uplord.uplordapi.dto.UpdateDetectDTO;

import java.util.List;

@Mapper
public interface UpdateDetectDAO {

    List<String> findPrimaryKeyColumnNames(UpdateDetectDTO param);

    int updateDetectedAllColumns(UpdateDetectDTO param);

    int updateDetectedCreatedColumns(UpdateDetectDTO param);

    int updateDetectedUpdatedColumns(UpdateDetectDTO param);

    boolean isExistsCreateColumns(UpdateDetectDTO param);

    boolean isExistsUpdateColumns(UpdateDetectDTO param);

}