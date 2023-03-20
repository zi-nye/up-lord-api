package uplord.uplordapi.event.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uplord.uplordapi.dto.MemberInfoDTO;
import uplord.uplordapi.event.service.BirthdayService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("event/birthday")
public class BirthdayController {
    private final BirthdayService service;

    @GetMapping
    public ResponseEntity<List<MemberInfoDTO>> findList(){
        return ResponseEntity.ok(service.findList());
    }
}
