package uplord.uplordapi.board.meeting.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uplord.uplordapi.board.meeting.service.PostsApiService;
import uplord.uplordapi.dto.AllPostsDto;
import uplord.uplordapi.dto.PostsDto;
import uplord.uplordapi.dto.PostsSaveRequestDto;
import uplord.uplordapi.dto.PostsUpdateDto;

import java.util.List;

@RestController
@RequestMapping("/board/meeting")
public class PostsApiController {
    private final PostsApiService postsApiService;

    @Autowired
    public PostsApiController(PostsApiService postsApiService) {
        this.postsApiService = postsApiService;
    }

    @GetMapping
    public ResponseEntity<String> findAll() {
        try {
            List<AllPostsDto> allPostsDTOs = postsApiService.findAll();
            ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
            return ResponseEntity.ok(objectMapper.writeValueAsString(allPostsDTOs));
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body("Can not Convert to JSON");
        }
    }

    @GetMapping("/{postId}")
    public ResponseEntity<String> findById(@PathVariable Long postId) {
        try {
            PostsDto postsDto = postsApiService.findById(postId);
            ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
            return ResponseEntity.ok(objectMapper.writeValueAsString(postsDto));
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body("Can not Convert to JSON");
        }
    }

    @PostMapping("/post")
    public ResponseEntity<String> save(@RequestBody PostsSaveRequestDto postsSaveRequestDto) {
        try {
            postsApiService.save(postsSaveRequestDto);
            ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
            return ResponseEntity.ok(objectMapper.writeValueAsString(postsSaveRequestDto));
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body("Can not Convert to JSON");
        }
    }

    @PutMapping("/{postId}")
    public ResponseEntity<String> update(@PathVariable Long postId, @RequestBody PostsSaveRequestDto postsSaveRequestDto) {
        try {
            PostsUpdateDto updateDto = PostsUpdateDto.builder()
                    .postId(postId)
                    .userId(postsSaveRequestDto.getUserId())
                    .title(postsSaveRequestDto.getTitle())
                    .content(postsSaveRequestDto.getContent())
                    .updatedAt(postsSaveRequestDto.getUpdatedAt())
                    .updatedIp(postsSaveRequestDto.getUpdatedIp())
                    .build();
            postsApiService.update(updateDto);

            ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
            return ResponseEntity.ok(objectMapper.writeValueAsString(updateDto));
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body("Can not Convert to JSON");
        }
    }
}
