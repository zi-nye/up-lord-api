package uplord.uplordapi.sysManage.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uplord.uplordapi.dto.MenuDTO;
import uplord.uplordapi.sysManage.service.MenuManageService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("sysManage/menuManage")
public class MenuManageController {

    private final MenuManageService service;

    @GetMapping("list")
    public ResponseEntity<List<MenuDTO>> findList(@Validated MenuDTO menuDto) throws Exception {
        return ResponseEntity.ok(service.findList(menuDto));
    }

    //Todo: 메뉴 수정기능 구현하기
    //      요구사항 : 메뉴명이 중복되면 수정 불가능하게 만들어야 하지 않나? -> 예외체크
    //      메뉴 수정에 성공하면 성공메시지 반환, 실패하면 실패 메시지 반환
    //      유효성 검사 필요한 것 : MENU_URL, MENU_NM, MENU_ORD
    @PutMapping("list/update/{menuCD}")
    public ResponseEntity<String> updateMenu(@PathVariable String menuCD,
            @RequestBody MenuDTO menuDTO) {
        try {
            // todo: 메뉴 순서 관련 유효성 검사
            //  메뉴 순서 범위 검사
            menuDTO.setMenuCd(menuCD);
            if (service.updateValidationCheck(menuDTO)) {
                log.info("#### Validation Success to update menu ####");
            }
            // todo: 기존의 메뉴와 순서를 변경할 경우
            service.updateMenu(menuDTO);
            return new ResponseEntity<>("Update_Ok", HttpStatus.OK);
        } catch (Exception exception) {
            String errorMsg = exception.getMessage();
            log.error("#### Fail to update the menu : {} ####", errorMsg);
            return new ResponseEntity<>(errorMsg, HttpStatus.OK);
        }
    }

    // todo : 신규 메뉴 추가기능 구현하기
    //  요구사항 : 메뉴명 중복체크기능이 필요 + 알아서 체크


}
