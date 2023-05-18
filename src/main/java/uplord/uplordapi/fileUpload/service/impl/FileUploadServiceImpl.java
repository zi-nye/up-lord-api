package uplord.uplordapi.fileUpload.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uplord.uplordapi.fileUpload.StorageProperties;
import uplord.uplordapi.fileUpload.exception.StorageException;
import uplord.uplordapi.fileUpload.exception.StorageFileNotFoundException;
import uplord.uplordapi.fileUpload.service.FileUploadService;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    private final Path rootLocation;
    private String folderName = "uploaded-files";

    @Autowired
    public FileUploadServiceImpl(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
        init();
    }

    @Override
    public void store(MultipartFile file) {
        try {
            isEmptyFile(file);
            Path destinationFile = this.rootLocation.resolve(folderName)
                    .resolve(Paths.get(file.getOriginalFilename()))
                    .normalize()
                    .toAbsolutePath();
            // todo : 로깅구현체로 바꾸기
            System.out.println("다음 경로에 업로드를 진행합니다. : " + destinationFile);
            isCurrentDirectory(destinationFile, this.rootLocation);
            copyDestinationFileIntoStorage(file, destinationFile);
        } catch (IOException e) {
            throw new StorageException("[ERROR] 파일 업로드에 실패했습니다.", e);
        }
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            Path targetLocation = this.rootLocation.resolve(folderName);
            return Files.walk(targetLocation, 1)
                    .filter(path -> !path.equals(targetLocation))
                    .map(targetLocation::relativize);
        } catch (IOException e) {
            throw new StorageException("[ERROR] 저장된 파일을 읽어오는데 실패했습니다.", e);
        }
    }

    @Override
    public Resource loadAsResource(String fileName) {
        try {
            Path file = load(fileName);
            Resource resource = new UrlResource(file.toUri());
            return checkResource(resource, fileName);
        } catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("[ERROR] 다음의 파일을 읽을 수 없습니다 : " + fileName, e);
        }
    }

    @Override
    public Path load(String fileName) {
        return rootLocation.resolve(folderName)
                .resolve(fileName);
    }

    public void changeUploadFolderLocation(String folderName) {
        this.folderName = folderName;
        init();
    }


    private void init() {
        try {
            if (isExistFolder(this.folderName)) {
                return;
            }
            Files.createDirectories(rootLocation.resolve(this.folderName));
        } catch (IOException e) {
            throw new StorageException("[ERROR] 스토리지를 초기화 할 수 없습니다.", e);
        }
    }

    private boolean isExistFolder(String folderName) throws IOException {
        try {
            return Files.walk(this.rootLocation, 1)
                    .anyMatch(path -> path.equals(this.rootLocation.resolve(folderName)));
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    private void isEmptyFile(MultipartFile file) {
        if (file.isEmpty()) {
            throw new StorageException("[ERROR] 파일이 비어있어 저장에 실패했습니다.");
        }
    }

    private void isCurrentDirectory(Path destinationFile, Path rootLocation) {
        if (!destinationFile.getParent()
                .equals(rootLocation.toAbsolutePath().resolve(folderName))) {
            throw new StorageException("[ERROR] 현재 디렉토리 바깥에 파일을 저장할 수 없습니다.");
        }
    }

    private void copyDestinationFileIntoStorage(MultipartFile file, Path destinationFile)
            throws IOException {
        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
        }
    }

    private Resource checkResource(Resource resource, String fileName) {
        if (!isResourceAvailable(resource)) {
            throw new StorageFileNotFoundException("[ERROR] 다음의 파일을 읽을 수 없습니다 : " + fileName);
        }
        return resource;
    }

    private boolean isResourceAvailable(Resource resource) {
        return resource.exists() || resource.isReadable();
    }
}
