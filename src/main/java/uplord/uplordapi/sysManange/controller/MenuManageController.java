package uplord.uplordapi.sysManange.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uplord.uplordapi.dto.MenuDTO;
import uplord.uplordapi.sysManange.service.MenuManageService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("sysManage/menuManage")
public class MenuManageController {

	private final MenuManageService service;

	@GetMapping
	public ResponseEntity<List<MenuDTO>> findList(MenuDTO menuDto) throws Exception{
		return ResponseEntity.ok(service.findList(menuDto));
	}
}