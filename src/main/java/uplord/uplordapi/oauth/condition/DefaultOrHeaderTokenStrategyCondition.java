package uplord.uplordapi.oauth.condition;

import org.springframework.boot.autoconfigure.condition.AnyNestedCondition;
import org.springframework.context.annotation.Conditional;

public class DefaultOrHeaderTokenStrategyCondition extends AnyNestedCondition {

    public DefaultOrHeaderTokenStrategyCondition() {
        super(ConfigurationPhase.REGISTER_BEAN);
    }

    @Conditional(DefaultTokenStrategyCondition.class)
    static class OnDefault {}

    @Conditional(HeaderTokenStrategyCondition.class)
    static class OnCookie {}
}