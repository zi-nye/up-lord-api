package uplord.uplordapi.sysManange.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uplord.uplordapi.sysManange.service.CellService;
import uplord.uplordapi.sysManange.vo.CellVO;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("sysManage/cell")
public class CellController {

    private final CellService service;

    @GetMapping
    public ResponseEntity<List<CellVO>> findList(CellVO param){
        return ResponseEntity.ok(service.findList(param));
    }
}
