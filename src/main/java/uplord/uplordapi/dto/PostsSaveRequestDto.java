package uplord.uplordapi.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private Long userId;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private String createdIp;
    private LocalDateTime updatedAt;
    private String updatedIp;

    @Builder
    public PostsSaveRequestDto(Long userId, String title, String content, LocalDateTime createdAt, String createdIp, LocalDateTime updatedAt, String updatedIp) {
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.createdIp = createdIp;
        this.updatedAt = updatedAt;
        this.updatedIp = updatedIp;
    }

    public PostsSaveRequestDto toEntity() {
        return PostsSaveRequestDto.builder()
                .userId(userId)
                .title(title)
                .content(content)
                .createdAt(createdAt)
                .createdIp(createdIp)
                .updatedAt(updatedAt)
                .updatedIp(updatedIp)
                .build();
    }
}
