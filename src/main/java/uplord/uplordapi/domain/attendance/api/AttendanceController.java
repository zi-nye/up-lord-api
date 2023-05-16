package uplord.uplordapi.domain.attendance.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uplord.uplordapi.common.model.CommonResponse;
import uplord.uplordapi.common.model.ErrorResponse;
import uplord.uplordapi.domain.attendance.application.AttendanceReadService;
import uplord.uplordapi.domain.attendance.application.AttendanceWriteService;
import uplord.uplordapi.domain.attendance.dto.AttendanceDto;
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
    @GetMapping("")
    public ResponseEntity<List<AttendanceResponseDto>> getAttendances(@RequestBody AttendanceDto requestDto) {
        return ResponseEntity.ok(attendanceReadService.findAttendanceByRequestDto(requestDto));
    }

    @Operation(summary = "출석부 등록")
    @PostMapping("")
    public ResponseEntity<List<AttendanceDto>> register(@RequestBody RegisterAttendanceCommand requestDto) {
        return ResponseEntity.ok(attendanceWriteService.registerAttendance(requestDto));
    }

    @Operation(summary = "출석 하기")
    @PutMapping("")
    public ResponseEntity<CommonResponse> update(@RequestBody AttendanceDto requestDto) {
        requestDto.setAttendanceYn('Y');
        attendanceWriteService.updateAttendance(requestDto);
        return ResponseEntity.ok(new CommonResponse());

    }

    @Operation(summary = "출석 취소")
    @PutMapping("/cancel")
    public ResponseEntity<CommonResponse> cancel(@RequestBody AttendanceDto requestDto) {
        requestDto.setAttendanceYn('N');
        attendanceWriteService.updateAttendance(requestDto);
        return ResponseEntity.ok(new CommonResponse());
    }
}
