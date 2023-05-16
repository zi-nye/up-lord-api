package uplord.uplordapi.domain.attendance.dto;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
public class AttendanceResponseDto implements Serializable {
    final private Long attendanceId;
    final private Long memberIdx;
    final private String memberName;
    final private int nthYear;
    final private String cellName;
    final private String  gender;
    final private Character attendanceYn;
    final private LocalDate attendanceDate;
    final private String memo;
    @Builder
    public AttendanceResponseDto(Long attendanceId, Long memberIdx, String memberName, int nthYear, String cellName, String gender, Character attendanceYn, LocalDate attendanceDate, String memo) {
        this.attendanceId = attendanceId;
        this.memberIdx = memberIdx;
        this.memberName = memberName;
        this.nthYear = nthYear;
        this.cellName = cellName;
        this.gender = gender;
        this.attendanceYn = attendanceYn;
        this.attendanceDate = attendanceDate;
        this.memo = memo;
    }
}
