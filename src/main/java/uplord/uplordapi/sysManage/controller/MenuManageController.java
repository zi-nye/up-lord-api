package uplord.uplordapi.sysManage.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uplord.uplordapi.dto.MenuDTO;
import uplord.uplordapi.sysManage.service.MenuManageService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("sysManage/menuManage")
public class MenuManageController {
	private final MenuManageService service;

	@GetMapping
	public ResponseEntity<List<MenuDTO>> findList(@Validated MenuDTO menuDto) throws Exception{
		return ResponseEntity.ok(service.findList(menuDto));
	}

	// todo : 신규 메뉴 추가기능 구현하기 *요구사항 : 메뉴명 중복체크기능이 필요 + 알아서 체크

	// todo : 메뉴 수정기능 구현하기 *요구사항 : 알아서 체크
}
