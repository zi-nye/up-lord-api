package uplord.uplordapi.common.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import uplord.uplordapi.dto.FileDTO;

import java.util.List;

@Mapper
@Repository
public interface FileDAO {
    int deleteAll(FileDTO param);

    int deleteOne(FileDTO param);

    FileDTO findOne(FileDTO param);

    List<FileDTO> findAll(FileDTO param);

    Integer nextIdx();

    Integer nextSeq(FileDTO seqParam);

    int save(FileDTO param);
}
