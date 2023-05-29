package uplord.uplordapi.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostsUpdateDto {
    private Long postId;
    private Long userId;
    private String title;
    private String content;
    private LocalDateTime updatedAt;
    private String updatedIp;

    @Builder
    public PostsUpdateDto(Long postId, Long userId, String title, String content, LocalDateTime updatedAt, String updatedIp) {
        this.postId = postId;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.updatedAt = updatedAt;
        this.updatedIp = updatedIp;
    }

    public PostsUpdateDto toEntity() {
        return PostsUpdateDto.builder()
                .postId(postId)
                .userId(userId)
                .title(title)
                .content(content)
                .updatedAt(updatedAt)
                .updatedIp(updatedIp)
                .build();
    }
}
