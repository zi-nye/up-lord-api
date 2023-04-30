package uplord.uplordapi.domain.attendance.entity;

import lombok.Builder;
import lombok.Getter;
import uplord.uplordapi.domain.attendance.enums.AttendanceStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class Attendance {
    private Long attendanceId;
    final private Long memberIdx;
    final private LocalDate attendanceDate;
    final private String memo;
    final private Character attendanceYn;
    final private Long createdUid;
    final private LocalDateTime createdAt;
    final private String createdIp;
    final private Long updatedUid;
    final private LocalDateTime updatedAt;
    final private String updatedIp;

    @Builder
    public Attendance(Long attendanceId, Long memberIdx, LocalDate attendanceDate, String memo, Character attendanceYn,  Long createdUid, LocalDateTime createdAt, String createdIp, Long updatedUid, LocalDateTime updatedAt, String updatedIp) {
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
    @Builder
    public Attendance(Long memberIdx, LocalDate attendanceDate, String memo, Character attendanceYn, Long createdUid, LocalDateTime createdAt, String createdIp, Long updatedUid, LocalDateTime updatedAt, String updatedIp) {
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

    public Attendance(Long attendanceId, Attendance attendance) {
        this.attendanceId = attendanceId;
        this.memberIdx = attendance.memberIdx;
        this.attendanceDate = attendance.attendanceDate;
        this.memo = attendance.memo;
        this.attendanceYn = attendance.attendanceYn;
        this.createdUid = attendance.createdUid;
        this.createdAt = attendance.createdAt;
        this.createdIp = attendance.createdIp;
        this.updatedUid = attendance.updatedUid;
        this.updatedAt = attendance.updatedAt;
        this.updatedIp = attendance.updatedIp;
    }

}
