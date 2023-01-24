package uplord.uplordapi.cell.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uplord.uplordapi.cell.service.CellSupportFeeManageService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cellSupportFeeManage")
public class CellSupportFeeManageController {

    private final CellSupportFeeManageService service;

}
