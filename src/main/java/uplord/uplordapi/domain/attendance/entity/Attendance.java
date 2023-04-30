package uplord.uplordapi.domain.attendance.entity;

import lombok.Builder;
import lombok.Getter;
import uplord.uplordapi.domain.attendance.enums.AttendanceStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class Attendance {
    final private Long attendanceId;
    final private Long memberIdx;
    final private LocalDate attendanceDate;
    final private String memo;
    final private AttendanceStatus attendanceYn;
    final private String createdUid;
    final private LocalDateTime createdAt;
    final private String createdIp;
    final private String updatedUid;
    final private LocalDateTime updatedAt;
    final private String updatedIp;

    @Builder
    public Attendance(Long attendanceId, Long memberIdx, LocalDate attendanceDate, String memo, AttendanceStatus attendanceYn,  String createdUid, LocalDateTime createdAt, String createdIp, String updatedUid, LocalDateTime updatedAt, String updatedIp) {
        this.attendanceId = attendanceId;
        this.memberIdx = memberIdx;
        this.attendanceDate = attendanceDate;
        this.memo = memo;
        this.attendanceYn = attendanceYn;
        this.createdUid = createdUid;
        this.createdAt = createdAt;
        this.createdIp = createdIp;
        this.updatedUid = updatedUid;
        this.updatedAt = updatedAt;
        this.updatedIp = updatedIp;
    }
}
