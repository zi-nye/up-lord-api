package uplord.uplordapi.common.dao;

import org.apache.ibatis.annotations.Mapper;
import uplord.uplordapi.common.vo.UpdateDetectVO;

import java.util.List;
@Mapper
public interface UpdateDetectDAO {

        List<String> findPrimaryKeyColumnNames(UpdateDetectVO param);

        int updateDetectedColumnsByInsertCommand(UpdateDetectVO param);

        int updateDetectedColumnsByUpdateCommand(UpdateDetectVO param);

        boolean isExistsCreateColumns(UpdateDetectVO param);

        boolean isExistsUpdateColumns(UpdateDetectVO param);

}
