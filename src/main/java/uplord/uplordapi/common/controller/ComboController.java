package uplord.uplordapi.common.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uplord.uplordapi.common.service.ComboService;
import uplord.uplordapi.dto.ComboDTO;
import uplord.uplordapi.dto.UserDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/combo")
public class ComboController {
    private ComboService service;

    // 유저 콤보 조회
    @GetMapping("/user")
    public ResponseEntity<List<ComboDTO>> getUserList() {
        return ResponseEntity.ok(service.getUserList());
    }

    // 권한 콤보 조회
    @GetMapping("/auth")
    public ResponseEntity<List<ComboDTO>> getAuthList() {
        return ResponseEntity.ok(service.getAuthList());
    }

    // 전체 메뉴 콤보
    @GetMapping("/allMenu")
    public ResponseEntity<List<ComboDTO>> getAllMenuList() {
        return ResponseEntity.ok(service.getAllMenuList());
    }

    // 상위 메뉴 콤보
    @GetMapping("/upperMenu")
    public ResponseEntity<List<ComboDTO>> getUpperMenuList() {
        return ResponseEntity.ok(service.getUpperMenuList());
    }

    // 하위 메뉴 콤보
    @GetMapping("/lowerMenu")
    public ResponseEntity<List<ComboDTO>> getLowerMenuList() {
        return ResponseEntity.ok(service.getLowerMenuList());
    }

    // 셀 콤보
    @GetMapping("/cell")
    public ResponseEntity<List<ComboDTO>> getCellList() {
        return ResponseEntity.ok(service.getCellList());
    }

    // 조직(셀) 깊이에 따른 조회 청량교회(ROOT -> Level 1) - 청년부(Level 2) -
    @GetMapping("/cellByLevel")
    public ResponseEntity<List<ComboDTO>> getCellListByLevel(ComboDTO param) {
        return ResponseEntity.ok(service.getCellListByLevel(param));
    }

    // 공통 코드 콤보
    @GetMapping("/commonCode")
    public ResponseEntity<List<ComboDTO>> getCommonCode(ComboDTO param) {
        return ResponseEntity.ok(service.getCommonCode(param));
    }

    //
}
