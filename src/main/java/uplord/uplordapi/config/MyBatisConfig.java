package uplord.uplordapi.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.annotation.Configuration;
import uplord.uplordapi.common.interceptor.mybatis.UpdateDetectInterceptor;
import uplord.uplordapi.common.service.impl.UpdateDetectExecutor;

@Configuration
public class MyBatisConfig {

    public MyBatisConfig(SqlSessionFactory sqlSessionFactory, UpdateDetectExecutor executor) {
        sqlSessionFactory.getConfiguration().addInterceptor(new UpdateDetectInterceptor(executor));
    }
}