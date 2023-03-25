package uplord.uplordapi.fileUpload;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("storage")
public class StorageProperties {

    private String location;

    public StorageProperties() {
        this.location = System.getProperty("user.dir");
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
