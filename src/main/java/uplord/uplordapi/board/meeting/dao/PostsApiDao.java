package uplord.uplordapi.board.meeting.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import uplord.uplordapi.dto.PostsSaveRequestDto;

@Mapper
@Repository
public interface PostsApiDao {
    Long save(PostsSaveRequestDto postsSaveRequestDto);
}
