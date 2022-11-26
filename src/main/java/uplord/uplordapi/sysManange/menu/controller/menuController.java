package uplord.uplordapi.sysManange.menu.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uplord.uplordapi.sysManange.menu.service.MenuService;
import uplord.uplordapi.sysManange.menu.dto.MenuDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("menuManage")
public class menuController {

	private final MenuService service;

	@GetMapping
	public ResponseEntity<List<MenuDto>> findList(MenuDto menuDto) throws Exception{
		return ResponseEntity.ok(service.findList(menuDto));
	}
}
