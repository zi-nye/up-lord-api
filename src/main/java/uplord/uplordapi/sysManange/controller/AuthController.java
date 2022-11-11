package uplord.uplordapi.sysManange.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uplord.uplordapi.common.model.CommonResponse;
import uplord.uplordapi.sysManange.service.AuthService;
import uplord.uplordapi.sysManange.vo.AuthVO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("sysManage/auth")
public class AuthController {

    private final AuthService service;

    // 권한 그룹 조회
    @GetMapping
    public ResponseEntity<List<AuthVO>> findAllAthList(AuthVO param){
        return ResponseEntity.ok(service.findAllAthList(param));
    }

    @PostMapping
    public ResponseEntity<CommonResponse> create(@RequestBody AuthVO param) {
        // TODO 세션값 넣는 로직 필요 -> 생성자 UID

        service.create(param);
        return ResponseEntity.ok(new CommonResponse());
    }

    @PutMapping
    public ResponseEntity<CommonResponse> update(@RequestBody AuthVO param){
        // TODO 세션값에 있는 유저 넣는 로직 필요 -> 수정자 UID, 수정자 IP

        service.update(param);
        return ResponseEntity.ok(new CommonResponse());
    }

    @PostMapping("athGp/create")
    public ResponseEntity<CommonResponse> createAthGp(@RequestBody AuthVO param) {
        // TODO 세션값 넣는 로직 필요 -> 생성자 UID

        service.createAthGp(param);
        return ResponseEntity.ok(new CommonResponse());
    }

    @PostMapping("athGp/delete")
    public ResponseEntity<CommonResponse> deleteAthGp(@RequestBody AuthVO param){
        // TODO 세션값에 있는 유저 넣는 로직 필요 -> 수정자 UID, 수정자 IP

        service.deleteAthGp(param);
        return ResponseEntity.ok(new CommonResponse());
    }


    // 권한이 없는 전체 메뉴 조회
    @GetMapping("notAthGp")
    public ResponseEntity<List<AuthVO>> getMenu(AuthVO param) {
        return ResponseEntity.ok(service.findNotAthGpList(param));
    }

    // 권한을 갖고 있는 메뉴 조회
    @GetMapping("athGp")
    public ResponseEntity<List<AuthVO>> getAthMenu(AuthVO param) {
        return ResponseEntity.ok(service.findAthGpList(param));
    }

}
