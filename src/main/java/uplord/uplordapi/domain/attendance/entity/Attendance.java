package uplord.uplordapi.domain.attendance.entity;

import lombok.Builder;
import lombok.Getter;
import uplord.uplordapi.domain.attendance.enums.AttendanceStatus;
import uplord.uplordapi.domain.attendance.enums.CompleteStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class Attendance {
    final private Long attendanceId;
    final private Long memberIdx;
    final private LocalDate writeDate;
    final private String memo;
    final private AttendanceStatus attendanceYn;
    final private CompleteStatus completeYn;
    final private String createdUid;
    final private LocalDateTime createdAt;
    final private String createdIp;
    final private String updatedUid;
    final private LocalDateTime updatedAt;
    final private String updatedIp;

    @Builder
    public Attendance(Long attendanceId, Long memberIdx, LocalDate writeDate, String memo, AttendanceStatus attendanceYn, CompleteStatus completeYn, String createdUid, LocalDateTime createdAt, String createdIp, String updatedUid, LocalDateTime updatedAt, String updatedIp) {
        this.attendanceId = attendanceId;
        this.memberIdx = memberIdx;
        this.writeDate = writeDate;
        this.memo = memo;
        this.attendanceYn = attendanceYn;
        this.completeYn = completeYn;
        this.createdUid = createdUid;
        this.createdAt = createdAt;
        this.createdIp = createdIp;
        this.updatedUid = updatedUid;
        this.updatedAt = updatedAt;
        this.updatedIp = updatedIp;
    }
}
