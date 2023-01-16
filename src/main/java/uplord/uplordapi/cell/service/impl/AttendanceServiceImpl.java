package uplord.uplordapi.cell.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uplord.uplordapi.cell.dao.AttendanceDAO;
import uplord.uplordapi.cell.service.AttendanceService;
import uplord.uplordapi.common.exception.NoCreatedDataException;
import uplord.uplordapi.common.exception.NoUpdatedDataException;
import uplord.uplordapi.dto.AttendanceDTO;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceDAO dao;
    @Override
    public List<AttendanceDTO> findAttendanceList(AttendanceDTO param) {
        return dao.findAttendanceList(param);
    }

    @Override
    public void create(AttendanceDTO param) {
        int result = 0;

        result += dao.create(param);

        if (result == 0) {
            throw new NoCreatedDataException();
        }
    }

    @Override
    public void update(AttendanceDTO param) {
        int result = 0;

        result += dao.update(param);

        if (result == 0) {
            throw new NoUpdatedDataException();
        }
    }
}
