package uplord.uplordapi.board.meeting.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import uplord.uplordapi.dto.AllPostsDto;
import uplord.uplordapi.dto.PostsDto;
import uplord.uplordapi.dto.PostsSaveRequestDto;
import uplord.uplordapi.dto.PostsUpdateDto;

import java.util.List;

@Mapper
@Repository
public interface PostsApiDao {
    Long save(PostsSaveRequestDto postsSaveRequestDto);
    Long update(PostsUpdateDto postsUpdateDto);
    PostsDto findById(Long postId);
    List<AllPostsDto> findAll();

}
