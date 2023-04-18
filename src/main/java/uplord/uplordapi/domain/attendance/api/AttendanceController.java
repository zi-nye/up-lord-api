package uplord.uplordapi.domain.attendance.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uplord.uplordapi.domain.attendance.application.AttendanceReadService;
import uplord.uplordapi.domain.attendance.application.AttendanceWriteService;
import uplord.uplordapi.domain.attendance.dto.AttendanceRequestDto;
import uplord.uplordapi.domain.attendance.dto.AttendanceResponseDto;
import uplord.uplordapi.domain.attendance.dto.RegisterAttendanceCommand;

import java.util.List;

// DDD 도메인 주도 계발의 패키지 구조로 domain 안에 여러 도메인들 패키지가 있고
// 그안에 api(Controller), application(Service), dao(Repository),
// dto(view - controller - service - dao ) 간에 객체 파라미터
// entity - DB 컬럼이랑 매칭된다.
// 등으로 구성된다.
@Tag(name = "출석 API")
@RestController
@RequestMapping("attendance")
@RequiredArgsConstructor
public class AttendanceController {
    final private AttendanceReadService attendanceReadService;
    final private AttendanceWriteService attendanceWriteService;

    @Operation(summary = "출석 조회")
    @GetMapping("/list")
    public ResponseEntity<List<AttendanceResponseDto>> getAttendances(@RequestBody AttendanceRequestDto attendanceRequestDto) {
        return ResponseEntity.ok(attendanceReadService.findAttendanceByRequestDto(attendanceRequestDto));
    }

    @Operation(summary = "출석 하기")
    @PostMapping("/")
    public ResponseEntity<Boolean> create(@RequestBody List<RegisterAttendanceCommand> command) {
        return ResponseEntity.ok(attendanceWriteService.createAttendance(command));
    }

    @Operation(summary = "출석 취소")
    @PutMapping("/")
    public ResponseEntity<Boolean> cancel(@RequestBody List<AttendanceRequestDto> command) {
        return ResponseEntity.ok(attendanceWriteService.cancelAttendance(command));
    }

}
