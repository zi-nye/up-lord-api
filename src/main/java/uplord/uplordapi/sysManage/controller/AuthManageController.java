package uplord.uplordapi.sysManage.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uplord.uplordapi.common.model.CommonResponse;
import uplord.uplordapi.sysManage.service.AuthManageService;
import uplord.uplordapi.dto.AuthDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("sysManage/authManage")
public class AuthManageController {

    private final AuthManageService service;

    // 권한 그룹 조회
    @GetMapping
    public ResponseEntity<List<AuthDTO>> findAllAthList(AuthDTO param){
        return ResponseEntity.ok(service.findAllAthList(param));
    }

    @PostMapping
    public ResponseEntity<CommonResponse> create(@RequestBody AuthDTO param) {
        // TODO 세션값 넣는 로직 필요 -> 생성자 UID

        service.create(param);
        return ResponseEntity.ok(new CommonResponse());
    }

    @PutMapping
    public ResponseEntity<CommonResponse> update(@RequestBody AuthDTO param){
        // TODO 세션값에 있는 유저 넣는 로직 필요 -> 수정자 UID, 수정자 IP

        service.update(param);
        return ResponseEntity.ok(new CommonResponse());
    }

    @PostMapping("athGp/create")
    public ResponseEntity<CommonResponse> createAthGp(@RequestBody AuthDTO param) {
        // TODO 세션값 넣는 로직 필요 -> 생성자 UID

        service.createAthGp(param);
        return ResponseEntity.ok(new CommonResponse());
    }

    @PostMapping("athGp/delete")
    public ResponseEntity<CommonResponse> deleteAthGp(@RequestBody AuthDTO param){
        // TODO 세션값에 있는 유저 넣는 로직 필요 -> 수정자 UID, 수정자 IP

        service.deleteAthGp(param);
        return ResponseEntity.ok(new CommonResponse());
    }


    // 권한이 없는 전체 메뉴 조회
    @GetMapping("notAthGp")
    public ResponseEntity<List<AuthDTO>> getMenu(AuthDTO param) {
        return ResponseEntity.ok(service.findNotAthGpList(param));
    }

    // 권한을 갖고 있는 메뉴 조회
    @GetMapping("athGp")
    public ResponseEntity<List<AuthDTO>> getAthMenu(AuthDTO param) {
        return ResponseEntity.ok(service.findAthGpList(param));
    }

}
