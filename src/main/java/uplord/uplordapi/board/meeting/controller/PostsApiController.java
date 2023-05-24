package uplord.uplordapi.board.meeting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uplord.uplordapi.board.meeting.service.PostsApiService;
import uplord.uplordapi.dto.PostsSaveRequestDto;

@RestController("/board/meeting")
public class PostsApiController {
    private final PostsApiService postsApiService;

    @Autowired
    public PostsApiController(PostsApiService postsApiService) {
        this.postsApiService = postsApiService;
    }

    @GetMapping("")
    public ResponseEntity<String> findAll() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> findById(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/post")
    public ResponseEntity<String> save(@RequestBody PostsSaveRequestDto postsSaveRequestDto) {
        Long success = postsApiService.save(postsSaveRequestDto);
        return ResponseEntity.ok(String.valueOf(success));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update() {
        return ResponseEntity.ok().build();
    }
}
