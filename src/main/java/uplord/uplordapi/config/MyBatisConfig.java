package uplord.uplordapi.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisConfig {

    public MyBatisConfig(SqlSessionFactory sqlSessionFactory) {
        sqlSessionFactory.getConfiguration();
    }

}