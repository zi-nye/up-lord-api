package uplord.uplordapi.fileUpload.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import uplord.uplordapi.fileUpload.exception.StorageException;
import uplord.uplordapi.fileUpload.exception.StorageFileNotFoundException;
import uplord.uplordapi.fileUpload.service.FileUploadService;

@RestController
@RequestMapping("/meetingDocs")
public class FileUploadController {

    private final FileUploadService fileUploadService;

    @Autowired
    public FileUploadController(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    @GetMapping("/")
    public ResponseEntity<List<String>> listUploadedFiles() throws IOException {
        try {
            List<String> filesURL = fileUploadService
                    .loadAll()
                    .map(path -> MvcUriComponentsBuilder
                            .fromMethodName(FileUploadController.class,
                                            "serveFile",
                                            path.getFileName().toString())
                            .build().toUri().toString())
                    .collect(Collectors.toList());
            return ResponseEntity.ok(filesURL);
        } catch (StorageException e) {
            // todo: 로깅구현체로 로깅하기
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        try {
            Resource file = fileUploadService.loadAsResource(filename);
            return ResponseEntity.ok()
                                 .header(HttpHeaders.CONTENT_DISPOSITION,
                                         "attachment; filename=\"" + file.getFilename() + "\"")
                                 .body(file);
        } catch (StorageFileNotFoundException e) {
            // todo: 로깅구현체로 로깅하기
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            fileUploadService.store(file);
            return ResponseEntity.ok("filename: " + file.getName() + ", status: 200");
        } catch (StorageException e) {
            // todo: 로깅구현체로 로깅하기
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException e) {
        // todo: 로깅구현체로 로깅하기
        System.out.println(e.getMessage());
        return ResponseEntity.notFound().build();
    }
}
