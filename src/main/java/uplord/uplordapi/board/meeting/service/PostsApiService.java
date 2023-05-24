package uplord.uplordapi.board.meeting.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uplord.uplordapi.board.meeting.dao.PostsApiDao;
import uplord.uplordapi.dto.PostsSaveRequestDto;

@Service
@RequiredArgsConstructor
public class PostsApiService {
    private final PostsApiDao postsApiDao;

    public Long save(PostsSaveRequestDto postsSaveRequestDto) {
        return postsApiDao.save(postsSaveRequestDto);
    }
}
