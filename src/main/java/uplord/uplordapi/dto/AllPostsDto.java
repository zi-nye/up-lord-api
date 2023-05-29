package uplord.uplordapi.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class AllPostsDto {
    private Long postId;
    private String userName;
    private String title;
    private Long views;
    private LocalDateTime createdAt;

    @Builder
    public AllPostsDto(Long postId, String userName, String title, Long views, LocalDateTime createdAt) {
        this.postId = postId;
        this.userName = userName;
        this.title = title;
        this.views = views;
        this.createdAt = createdAt;
    }

    public AllPostsDto toEntity() {
        return AllPostsDto.builder()
                .userName(userName)
                .title(title)
                .views(views)
                .createdAt(createdAt)
                .build();
    }
}
