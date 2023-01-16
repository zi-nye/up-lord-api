package uplord.uplordapi.common.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uplord.uplordapi.auth.annotation.Permit;
import uplord.uplordapi.common.service.MenuService;
import uplord.uplordapi.dto.MenuDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menus")
public class MenuController {
    private final MenuService service;

    @Permit
    @GetMapping
    public ResponseEntity<List<MenuDTO>> menus() {
        return ResponseEntity.ok(service.getMenus());
    }

}
