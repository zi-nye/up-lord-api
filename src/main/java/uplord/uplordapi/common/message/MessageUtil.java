package uplord.uplordapi.common.message;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class MessageUtil {

    private final MessageSource messageSourceBean;

    private static MessageSource messageSource;

    @PostConstruct
    public void initialize() {
        messageSource = messageSourceBean;
    }

    public static String getMessage(String messageCode) {
        return messageSource.getMessage(messageCode, null, LocaleContextHolder.getLocale());
    }

    public static String getMessage(String messageCode, Object[] args) {
        return messageSource.getMessage(messageCode, args, LocaleContextHolder.getLocale());
    }

}
