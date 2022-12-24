package uplord.uplordapi.sysManage.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uplord.uplordapi.common.model.CommonResponse;
import uplord.uplordapi.dto.UserDTO;
import uplord.uplordapi.sysManage.service.UserManageService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("sysManage/userManage")
public class UserManageController {
    private final UserManageService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findList(UserDTO param){
        return ResponseEntity.ok(service.findList(param));
    }

    @PutMapping
    public ResponseEntity<CommonResponse> update(@RequestBody UserDTO param){
        service.update(param);
        return ResponseEntity.ok(new CommonResponse());
    }
}
