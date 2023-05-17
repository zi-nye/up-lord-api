package uplord.uplordapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import uplord.uplordapi.fileUpload.StorageProperties;

@EnableAsync
@EnableScheduling
@ConfigurationPropertiesScan
@EnableConfigurationProperties(StorageProperties.class)
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class UpLordApiApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(UpLordApiApplication.class);
        application.addListeners(new ApplicationPidFileWriter());
        application.run(args);
    }
}
