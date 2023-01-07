package uplord.uplordapi.common.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileKey {

    private Integer fileIdx;
    private Integer fileSrlno;

    public FileKey() {}

    public FileKey(Integer fileIdx) {
        this.fileIdx = fileIdx;
    }
}
