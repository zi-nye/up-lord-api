package uplord.uplordapi.sysManage.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uplord.uplordapi.common.model.CommonResponse;
import uplord.uplordapi.dto.CommonDetailCodeDTO;
import uplord.uplordapi.sysManage.service.CommonCodeManageService;
import uplord.uplordapi.dto.CommonCodeDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("sysManage/commonCodeManage")
public class CommonCodeManageController {

    private final CommonCodeManageService service;

    @GetMapping("hirCodeList")
    public ResponseEntity<List<CommonCodeDTO>> findHirCodeList(CommonCodeDTO param){
        return ResponseEntity.ok(service.findHirCodeList(param));
    }

    @GetMapping("detailCodeList")
    public ResponseEntity<List<CommonDetailCodeDTO>> findDetailCodeList(CommonDetailCodeDTO param){
        return ResponseEntity.ok(service.findDetailCodeList(param));
    }


    @PostMapping("hir/create")
    public ResponseEntity<CommonResponse> hirCodeCreate(@RequestBody CommonCodeDTO param) {
        // TODO 세션값 넣는 로직 필요 -> 생성자 UID

        service.hirCodeCreate(param);
        return ResponseEntity.ok(new CommonResponse());
    }

    @PostMapping("detail/create")
    public ResponseEntity<CommonResponse> detailCodeCreate(@RequestBody CommonDetailCodeDTO param) {
        // TODO 세션값 넣는 로직 필요 -> 생성자 UID

        service.detailCodeCreate(param);
        return ResponseEntity.ok(new CommonResponse());
    }

    @PutMapping("hir/update")
    public ResponseEntity<CommonResponse> hirCodeUpdate(@RequestBody CommonCodeDTO param){
        // TODO 세션값에 있는 유저 넣는 로직 필요 -> 수정자 UID, 수정자 IP

        service.hirCodeUpdate(param);
        return ResponseEntity.ok(new CommonResponse());
    }

    @PutMapping("detail/update")
    public ResponseEntity<CommonResponse> detailCodeUpdate(@RequestBody CommonDetailCodeDTO param){
        // TODO 세션값에 있는 유저 넣는 로직 필요 -> 수정자 UID, 수정자 IP

        service.detailCodeUpdate(param);
        return ResponseEntity.ok(new CommonResponse());
    }
}
