package uplord.uplordapi.sysManange.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uplord.uplordapi.sysManange.service.MenuService;
import uplord.uplordapi.sysManange.vo.MenuVo;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("menuManage")
public class menuController {

	private final MenuService service;

	@GetMapping
	public ResponseEntity<List<MenuVo>> findList(MenuVo param) {
		return ResponseEntity.ok(service.findList(param));
	}
}
