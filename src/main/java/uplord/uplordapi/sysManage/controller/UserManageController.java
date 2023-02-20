package uplord.uplordapi.sysManage.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uplord.uplordapi.dto.UserDTO;
import uplord.uplordapi.dto.UserUpdateResultDTO;
import uplord.uplordapi.sysManage.service.UserManageService;

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
