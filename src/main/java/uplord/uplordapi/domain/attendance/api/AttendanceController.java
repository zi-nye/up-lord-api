package uplord.uplordapi.domain.attendance.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uplord.uplordapi.common.model.CommonResponse;
import uplord.uplordapi.domain.attendance.application.AttendanceReadService;
import uplord.uplordapi.domain.attendance.application.AttendanceWriteService;
import uplord.uplordapi.domain.attendance.dto.AttendanceDto;
import uplord.uplordapi.domain.attendance.dto.AttendanceResponseDto;
import uplord.uplordapi.domain.attendance.dto.RegisterAttendanceCommand;
import uplord.uplordapi.domain.attendance.exception.RegisterDupException;

import java.time.LocalDate;
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
    public ResponseEntity<List<AttendanceResponseDto>> getAttendances(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate attendanceDate) {
        return ResponseEntity.ok(attendanceReadService.findAttendance(attendanceDate));
    }

    @Operation(summary = "출석부 등록")
    @PostMapping("")
    public ResponseEntity<String> register(@RequestBody RegisterAttendanceCommand requestDto) {
        try {
            List<AttendanceDto> list = attendanceWriteService.registerAttendance(requestDto);
            ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
            return ResponseEntity.ok(objectMapper.writeValueAsString(list));
        } catch (RegisterDupException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body("[ERROR] 출석부가 중복 될 수 없습니다.");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
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
