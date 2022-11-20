package uplord.uplordapi.oauth.session;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.util.Strings;

import javax.servlet.http.HttpSession;

/**
 * 토큰 기반 인증 방식을 사용할 때 큰 단점 중 한 가지는
 * 토큰이 탈취되거나 했을 때, 서버에서 직접 인증 정보를 만료시키지 못 하는 것입니다.
 *
 * 이 클래스는 토큰 정보를 세션에 담아 서버에서 관리하기 위해 사용하는 Session Util 클래스입니다.
 * 기존 스프링 시큐리티와 같은 세션을 이용하지 않고 이 방식을 사용하는 이유는 확장성 때문입니다.
 * 만일 세션 클러스터링이 필요한 경우가 발생했을 때, 기존 코드는 일체 변경없이 바로 세션 클러스터링이 가능합니다.
 * 
 * 예를 들어, spring-session-data-redis 환경을 설정하면 코드 수정없이 곧바로 세션 클러스터링을 달성할 수 있습니다.
 */

public class TokenSession {

    public final static String SESSION_KEY_IN_CLAIMS = "$sessionId";
    public final static String SESSION_KEY_SUFFIX = "$token";

    private TokenSession() {};

    private static String getKey(String key) {
        return key + SESSION_KEY_SUFFIX;
    }

    public static void set(HttpSession session, String key, String jwt, Long timeout) {
        remove(session, key);

        session.setAttribute(getKey(key), jwt);
        session.setMaxInactiveInterval(timeout.intValue());
    }
    public static void remove(HttpSession session, String key) {
        session.removeAttribute(getKey(key));
    }

    public static boolean equals(HttpSession session, String key, String jwt) {
        String oldJwt = String.valueOf(session.getAttribute(getKey(key)));
        return exists(session, key) && StringUtils.equals(oldJwt, jwt);
    }

    public static boolean exists(HttpSession session, String key) {
        if (session == null) {
            return false;
        }
        Object value = session.getAttribute(getKey(key));
        return value != null && Strings.isNotEmpty(String.valueOf(value));
    }

}