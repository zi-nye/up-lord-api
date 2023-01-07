package uplord.uplordapi.common.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uplord.uplordapi.common.service.FileService;
import uplord.uplordapi.dto.FileDTO;

import java.util.List;
@RestController
@RequestMapping("/files")
@RequiredArgsConstructor
public class FileController {
    private final FileService fileService;

    @GetMapping("/{fileIdx}")
    public ResponseEntity<List<FileDTO>> files(@PathVariable("fileIdx") Integer fileIdx) {
        return ResponseEntity.ok(fileService.getAllFiles(fileIdx));
    }
}
