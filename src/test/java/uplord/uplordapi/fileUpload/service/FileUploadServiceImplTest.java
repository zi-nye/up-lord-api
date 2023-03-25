package uplord.uplordapi.fileUpload.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import uplord.uplordapi.fileUpload.StorageProperties;
import uplord.uplordapi.fileUpload.exception.StorageException;
import uplord.uplordapi.fileUpload.service.impl.FileUploadServiceImpl;

public class FileUploadServiceImplTest {

    private final StorageProperties properties = new StorageProperties();
    private FileUploadService service;

    @BeforeEach
    public void setUp() {
        service = new FileUploadServiceImpl(properties);
        service.changeUploadFolderLocation("test");
    }

    @AfterEach
    public void breakDown() throws IOException {
        Path dirPath = Paths.get(properties.getLocation())
                            .getParent()
                            .resolve("test");
        Files.walk(dirPath, 1)
             .filter(Files::isRegularFile)
             .forEach(file -> {
                 try {
                     Files.delete(file);
                 } catch (IOException e) {
                     throw new RuntimeException(e);
                 }
             });
        Files.delete(dirPath);
    }

    @Test
    @DisplayName("존재하지 않는 파일을 로드")
    public void loadNonExistent() {
        assertThat(service.load("foo.txt")).doesNotExist();
    }

    @Test
    @DisplayName("파일업로드 후 업로드 확인 테스트")
    public void saveAndLoad() {
        // given
        MockMultipartFile mockFile = new MockMultipartFile("foo",
                                                           "foo.txt",
                                                           MediaType.TEXT_PLAIN_VALUE,
                                                           "Hello, MockTest".getBytes());
        // when
        service.store(mockFile);
        // then
        assertThat(service.load("foo.txt")).exists();
    }

    @Test
    @DisplayName("허용되지 않은 상대경로에 업로드를 할 경우")
    public void saveRelativePathNotPermitted() {
        // given
        MockMultipartFile mockFile = new MockMultipartFile("foo",
                                                           "../foo.txt",
                                                           MediaType.TEXT_PLAIN_VALUE,
                                                           "Hello, MockTest".getBytes());
        //when, then
        assertThatThrownBy(() -> service.store(mockFile))
                .isInstanceOf(StorageException.class)
                .hasMessageContaining("[ERROR] 현재 디렉토리 바깥에 파일을 저장할 수 없습니다.");
    }

    @Test
    @DisplayName("허용되지 않은 절대경로에 업로드를 할 경우")
    public void saveAbsolutePathNotPermitted() {
        // given
        MockMultipartFile mockFile = new MockMultipartFile("foo",
                                                           "foo/foo-test",
                                                           MediaType.TEXT_PLAIN_VALUE,
                                                           "Hello, MockTest".getBytes());
        //when, then
        assertThatThrownBy(() -> service.store(mockFile))
                .isInstanceOf(StorageException.class)
                .hasMessageContaining("[ERROR] 현재 디렉토리 바깥에 파일을 저장할 수 없습니다.");
    }
}
