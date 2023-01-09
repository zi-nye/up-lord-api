package uplord.uplordapi.common.interceptor.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import uplord.uplordapi.common.domain.UpdateDetect;
import uplord.uplordapi.common.service.impl.UpdateDetectExecutor;

@Slf4j
@Intercepts({@Signature(type= Executor.class, method = "update", args = {MappedStatement.class, Object.class})})
public class UpdateDetectInterceptor implements Interceptor {

    private final UpdateDetectExecutor detectExecutor;

    public UpdateDetectInterceptor(UpdateDetectExecutor detectExecutor) {
        this.detectExecutor = detectExecutor;
    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        MappedStatement statement = (MappedStatement) args[0];
        SqlCommandType commandType = statement.getSqlCommandType();
        Object param = args[1];

        Object result = invocation.proceed();

        if (isTarget(param, commandType) && ((Integer) result) > 0) {
            String sql = statement.getBoundSql(param).getSql();
            detectExecutor.execute(commandType, sql, param);
        }
        return result;
    }

    private boolean isTarget(Object arg, SqlCommandType commandType) {
        return arg instanceof UpdateDetect && (isInsert(commandType) || isUpdate(commandType));
    }

    private boolean isInsert(SqlCommandType commandType) {
        return SqlCommandType.INSERT == commandType;
    }

    private boolean isUpdate(SqlCommandType commandType) {
        return SqlCommandType.UPDATE == commandType;
    }

}