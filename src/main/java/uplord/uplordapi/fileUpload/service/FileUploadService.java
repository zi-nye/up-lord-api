package uplord.uplordapi.fileUpload.service;

import java.nio.file.Path;
import java.util.stream.Stream;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

    void store(MultipartFile file);

    Stream<Path> loadAll();

    Path load(String fileName);

    Resource loadAsResource(String fileName);

    public void changeUploadFolderLocation(String folderName);
}
