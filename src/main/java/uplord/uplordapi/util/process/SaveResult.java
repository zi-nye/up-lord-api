package uplord.uplordapi.util.process;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SaveResult {

    private int createdCount;
    private int updatedCount;
    private int totalCount;

    public boolean existsCreatedData() {
        return createdCount > 0;
    }

    public boolean existsUpdatedData() {
        return updatedCount > 0;
    }

}