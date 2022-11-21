package uplord.uplordapi.oauth.service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import uplord.uplordapi.common.JwtTokenProvider;
import uplord.uplordapi.oauth.dao.OauthDAO;
import uplord.uplordapi.oauth.vo.UserVO;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OAuthService {

    @Value("${kakao.rest-api-key}")
    private String KAKAO_REST_API_KEY;

    @Value("${kakao.redirect-url}")
    private String KAKAO_REDIRECT_URL;

    private final OauthDAO dao;

    private final RestTemplate restTemplate;

    private final JwtTokenProvider jwtTokenProvider;


    public String getKakaoAccessToken(String code) throws IOException { // TODO 다른 곳으로 빼기

        String access_Token = "";
        String refresh_Token = "";
        String reqURL = "https://kauth.kakao.com/oauth/token";

        // param
        MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
        param.add("grant_type", "authorization_code");
        param.add("client_id", KAKAO_REST_API_KEY);
        param.add("redirect_uri", KAKAO_REDIRECT_URL);
        param.add("code", code);

        Map<String, String> result = restTemplate.postForObject(reqURL, param, Map.class);

        access_Token = result.get("access_token");
        refresh_Token = result.get("refresh_token");

        // TODO refresh_token의 경우 DB에 저장해야하는가?
        //  해야한다면 createKakaoUser에서 수행할 것.
        System.out.println("refresh_token : " + refresh_Token);

        return access_Token;
    }

    public String createKakaoUser(String token) throws IOException {

        String reqURL = "https://kapi.kakao.com/v2/user/me";

        //access_token을 이용하여 사용자 정보 조회
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization","Bearer " + token);
        Map<String, Object> result = restTemplate.postForObject(reqURL,new HttpEntity<>(headers), Map.class);

        System.out.println(result);

        String snsId = result.get("id").toString();

        Map<String, Object> kakaoAccount = (Map<String, Object>) result.get("kakao_account");
        Map<String, String> profile = (Map<String, String>) kakaoAccount.get("profile");

        System.out.println(kakaoAccount);

        String name = profile.get("nickname");

        boolean hasEmail = (Boolean) kakaoAccount.get("has_email");
        String email = "";
        if (hasEmail) {
            email = kakaoAccount.get("email").toString();
        }

        // 등록된 유저가 아니라면, 신규 삽입
        if (dao.findUserBySnsId(snsId) == null) {
            UserVO user = UserVO.builder()
                    .snsType("KAKAO")
                    .snsId(snsId)
                    .userEmail(email)
                    .userName(name)
                    .build();

            dao.createUser(user);
        }

        UserVO user = dao.findUserBySnsId(snsId);

        System.out.println(user);

        // TODO 토큰 발급
        return jwtTokenProvider.createToken(user.getUsername());
    }
}
