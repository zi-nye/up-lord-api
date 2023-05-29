package uplord.uplordapi.board.meeting.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uplord.uplordapi.board.meeting.dao.PostsApiDao;
import uplord.uplordapi.dto.AllPostsDto;
import uplord.uplordapi.dto.PostsDto;
import uplord.uplordapi.dto.PostsSaveRequestDto;
import uplord.uplordapi.dto.PostsUpdateDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostsApiService {
    private final PostsApiDao postsApiDao;

    public Long save(PostsSaveRequestDto postsSaveRequestDto) {
        return postsApiDao.save(postsSaveRequestDto);
    }

    public Long update(PostsUpdateDto postsUpdateDto) {
        return postsApiDao.update(postsUpdateDto);
    }

    public PostsDto findById(Long postId) {
        /* todo: 누군가 게시물을 조회했을 때, 게시물의 조회수를 올려야 한다.
            나중에 할 것 -> 조회수 조작을 방지하기 위한 로직이 필요하지 않을까?
        */
        return postsApiDao.findById(postId);
    }

    public List<AllPostsDto> findAll() {
        return postsApiDao.findAll();
    }
}
