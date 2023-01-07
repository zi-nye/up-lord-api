package uplord.uplordapi.dto;

import lombok.Getter;
import lombok.Setter;
import uplord.uplordapi.enums.DeleteType;

@Getter
@Setter
public class FileDTO {

    private Integer fileIdx;
    private Integer fileSrlno;
    private String name;
    private Long size;
    private String type;
    private byte[] src;
    private DeleteType deleteAt = DeleteType.N;
    private Integer sortOrder;
    private Integer fileSeq;
}