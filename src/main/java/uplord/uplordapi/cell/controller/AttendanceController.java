package uplord.uplordapi.cell.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uplord.uplordapi.cell.service.AttendanceService;
import uplord.uplordapi.common.model.CommonResponse;
import uplord.uplordapi.dto.AttendanceDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("cellManage/attendance")
public class AttendanceController {
    private final AttendanceService service;

    @GetMapping
    public ResponseEntity<List<AttendanceDTO>> findAttendanceList(AttendanceDTO param){
        return ResponseEntity.ok(service.findAttendanceList(param));
    }

    @PostMapping
    public ResponseEntity<CommonResponse> create(@RequestBody AttendanceDTO param){
        service.create(param);
        return ResponseEntity.ok(new CommonResponse());
    }

    @PutMapping
    public ResponseEntity<CommonResponse> update(@RequestBody AttendanceDTO param){
        service.update(param);
        return ResponseEntity.ok(new CommonResponse());
    }
}
