package uplord.uplordapi.sysManage.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uplord.uplordapi.dto.LoginHistoryDTO;
import uplord.uplordapi.sysManage.service.LoginHistoryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("sysManage/loginHistory")
public class LoginHistoryController {
    private final LoginHistoryService service;

    @GetMapping
    public ResponseEntity<List<LoginHistoryDTO>> findLoginHistoryList(LoginHistoryDTO param){
        return ResponseEntity.ok(service.findLoginHistoryList(param));
    }

}
