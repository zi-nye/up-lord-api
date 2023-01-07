package uplord.uplordapi.auth.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Base64;
@Slf4j
public class HttpHelper {
    public static final String E_SIGN_HEADER_NAME = "e-sign";
    public static final String MENU_CD_HEADER_NAME = "crk-fa";

    public static boolean isInternalErrorRequest() {
        String uri = getHttpServletRequest().getRequestURI();
        return uri != null && uri.contains("/error");
    }

    public static boolean isExistsInRequestHeader(String headerName) {
        return getHttpServletRequest().getHeader(headerName) != null;
    }

    public static String getMenuCodeAtRequestHeader() {
        if (!isExistsInRequestHeader(MENU_CD_HEADER_NAME)) {
            return null;
        }
        return new String(Base64.getDecoder().decode(getRequestHeader(MENU_CD_HEADER_NAME)));
    }

    public static HttpServletRequest getHttpServletRequest() {
        return getServletRequestAttributes().getRequest();
    }

    public static ServletRequestAttributes getServletRequestAttributes() {
        return (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
    }

    public static HttpSession getCurrentSession() {
        return getHttpServletRequest().getSession(false);
    }

    public static String getRequestHeader(String headerName) {
        if (!isExistsInRequestHeader(headerName)) {
            log.error("[HttpHelper.getRequestHeader] Not found header. header name: {}", headerName);
        }
        return getHttpServletRequest().getHeader(headerName);
    }

    public static String getClientIp() {
        HttpServletRequest request = getHttpServletRequest();
        String ip = request.getHeader("X-Forwarded-For");

        if (isInvalidIP(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (isInvalidIP(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (isInvalidIP(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (isInvalidIP(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (isInvalidIP(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    private static boolean isInvalidIP(String ip) {
        return ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip);
    }
}
