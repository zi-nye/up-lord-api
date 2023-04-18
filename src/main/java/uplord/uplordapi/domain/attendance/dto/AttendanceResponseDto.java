package uplord.uplordapi.domain.attendance.dto;

import lombok.Builder;
import uplord.uplordapi.domain.attendance.enums.AttendanceStatus;

import java.time.LocalDate;

public class AttendanceResponseDto {
    final private Long attendanceId;
    final private Long memberIdx;
    final private AttendanceStatus attendanceYn;
    final private LocalDate writeDate;
    final private String memo;
    @Builder
    public AttendanceResponseDto(Long attendanceId, Long memberIdx, AttendanceStatus attendanceYn, LocalDate writeDate, String memo) {
        this.attendanceId = attendanceId;
        this.memberIdx = memberIdx;
        this.attendanceYn = attendanceYn;
        this.writeDate = writeDate;
        this.memo = memo;
    }
}
