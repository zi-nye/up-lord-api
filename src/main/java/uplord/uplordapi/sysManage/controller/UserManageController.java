package uplord.uplordapi.sysManage.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uplord.uplordapi.common.model.CommonResponse;
import uplord.uplordapi.dto.UserDTO;
import uplord.uplordapi.dto.UserUpdateResultDTO;
import uplord.uplordapi.sysManage.service.UserManageService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("sysManage/userManage")
public class UserManageController {
    private final UserManageService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findList(){
        return ResponseEntity.ok(service.findList());
    }

    @PutMapping
    public ResponseEntity<List<UserUpdateResultDTO>> update(@RequestBody List<UserDTO> param) throws Exception {
        return ResponseEntity.ok(service.update(param));
    }
}
