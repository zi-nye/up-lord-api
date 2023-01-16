package uplord.uplordapi.common.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import uplord.uplordapi.dto.ErrorDTO;

@Mapper
@Repository
public interface ErrorDAO {
    Long nextIdx();

    int create(ErrorDTO vo);
}
