package uplord.uplordapi.sysManage.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uplord.uplordapi.common.model.CommonResponse;
import uplord.uplordapi.dto.HolidayDTO;
import uplord.uplordapi.sysManage.service.HolidayManageService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("sysManage/commonCode")
public class HolidayManageController {
    private final HolidayManageService service;

    @GetMapping
    public ResponseEntity<List<HolidayDTO>> findHolidayList(HolidayDTO param){
        return ResponseEntity.ok(service.findHolidayList(param));
    }

    @PostMapping
    public ResponseEntity<CommonResponse> create(HolidayDTO param){
        service.create(param);
        return ResponseEntity.ok(new CommonResponse());
    }

    @PutMapping
    public ResponseEntity<CommonResponse> update(HolidayDTO param){
       service.update(param);
       return ResponseEntity.ok(new CommonResponse());
    }

}
