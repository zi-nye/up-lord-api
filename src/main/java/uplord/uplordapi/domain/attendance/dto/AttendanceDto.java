package uplord.uplordapi.domain.attendance.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
public class AttendanceDto {
    private final Long attendanceId;
    private final Long memberIdx;
    private final LocalDate attendanceDate;
    private final String memo;
    private final Character attendanceYn;
    private final Long createdUid;
    private final LocalDateTime createdAt;
    private final String createdIp;
    private final Long updatedUid;
    private final LocalDateTime updatedAt;
    private final String updatedIp;
    @Builder
    public AttendanceDto(Long attendanceId, Long memberIdx, LocalDate attendanceDate, String memo, Character attendanceYn, Long createdUid, LocalDateTime createdAt, String createdIp, Long updatedUid, LocalDateTime updatedAt, String updatedIp) {
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
