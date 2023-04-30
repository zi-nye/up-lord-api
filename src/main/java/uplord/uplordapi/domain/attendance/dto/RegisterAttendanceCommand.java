package uplord.uplordapi.domain.attendance.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
public class RegisterAttendanceCommand {
    final private LocalDate attendanceDate;
    final private Long memberIdx;
    final private String memo;
    final private Character attendanceYn;
    final private Integer createdUid;
    final private LocalDateTime createdAt;
    final private String createdIp;
    final private Integer updatedUid;
    final private LocalDateTime updatedAt;
    final private String updatedIp;
    @Builder
    public RegisterAttendanceCommand(LocalDate attendanceDate, Long memberIdx, String memo, Character attendanceYn, Integer createdUid, LocalDateTime createdAt, String createdIp, Integer updatedUid, LocalDateTime updatedAt, String updatedIp) {
        this.attendanceDate = attendanceDate;
        this.memberIdx = memberIdx;
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
