package uplord.uplordapi.oauth.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import uplord.uplordapi.oauth.domain.TokenStrategyProperty;

public class CookieTokenStrategyCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String strategy = context.getEnvironment().getProperty("auth.token.strategy");
        return TokenStrategyProperty.COOKIE.equals(strategy);
    }
}