package uplord.uplordapi.common.service;

import org.springframework.web.multipart.MultipartFile;
import uplord.uplordapi.common.domain.FileKey;
import uplord.uplordapi.dto.FileDTO;

import java.util.List;

public interface FileService {
    FileDTO getFile(FileKey fileKey);

    List<FileDTO> getAllFiles(Integer fileIdx);

    /**
     * fileIdx를 신규 생성하면서 저장할 때 사용합니다.
     * 이미 생성되어 있는 fileIdx에 파일을 저장할 때는 fileIdx를 인자로 받는 오버로딩 메서드를 사용하세요.
     */
    FileKey save(List<MultipartFile> files);

    FileKey save(List<MultipartFile> files, Integer fileIdx);

    void deleteFile(FileKey fileKey);

    void deleteAllFiles(Integer fileIdx);
}
