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

    @GetMapping
    public ResponseEntity<List<AuthVO>> findList(AuthVO param){
        return ResponseEntity.ok(service.findList(param));
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
}
