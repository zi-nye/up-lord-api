package uplord.uplordapi.domain.attendance.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Objects;

@Getter
public class RegisterAttendanceCommand {
    final private LocalDate attendanceDate;
    final private String memberIdx;

    @Builder
    public RegisterAttendanceCommand(LocalDate attendanceDate, String memberIdx) {
        this.attendanceDate = Objects.requireNonNull(attendanceDate);
        this.memberIdx = Objects.requireNonNull(memberIdx);
    }
}
