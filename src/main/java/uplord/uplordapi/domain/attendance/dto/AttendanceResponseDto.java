package uplord.uplordapi.domain.attendance.dto;

import lombok.Builder;
import uplord.uplordapi.domain.attendance.enums.AttendanceStatus;

import java.time.LocalDate;

public class AttendanceResponseDto {
    final private Long attendanceId;
    final private Long memberIdx;
    final private Character attendanceYn;
    final private LocalDate attendanceDate;
    final private String memo;
    @Builder
    public AttendanceResponseDto(Long attendanceId, Long memberIdx, Character attendanceYn, LocalDate attendanceDate, String memo) {
        this.attendanceId = attendanceId;
        this.memberIdx = memberIdx;
        this.attendanceYn = attendanceYn;
        this.attendanceDate = attendanceDate;
        this.memo = memo;
    }
}
