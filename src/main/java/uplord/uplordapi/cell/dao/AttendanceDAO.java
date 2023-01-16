package uplord.uplordapi.cell.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import uplord.uplordapi.dto.AttendanceDTO;

import java.util.List;

@Mapper
@Repository
public interface AttendanceDAO {
    List<AttendanceDTO> findAttendanceList(AttendanceDTO param);
    int create(AttendanceDTO param);
    int update(AttendanceDTO param);

}
