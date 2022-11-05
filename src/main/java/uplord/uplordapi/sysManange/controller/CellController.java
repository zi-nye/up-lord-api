package uplord.uplordapi.sysManange.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uplord.uplordapi.sysManange.service.CellService;
import uplord.uplordapi.sysManange.vo.CellVO;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/sysManage")
public class CellController {

    private CellService service;

    @GetMapping("/cell")
    public List<CellVO> findList(CellVO param){
        return service.findList(param);
    }
}
