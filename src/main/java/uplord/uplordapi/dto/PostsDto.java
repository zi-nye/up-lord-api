package uplord.uplordapi.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostsDto {
    private Long postId;
    private String userName;
    private String userEmail;
    private String title;
    private String content;
    private Long views;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public PostsDto(Long postId, String userName, String userEmail, String title, String content, Long views, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.postId = postId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.title = title;
        this.content = content;
        this.views = views;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public PostsDto toEntity() {
        return PostsDto.builder()
                .userName(userName)
                .userEmail(userEmail)
                .title(title)
                .content(content)
                .views(views)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }
}
