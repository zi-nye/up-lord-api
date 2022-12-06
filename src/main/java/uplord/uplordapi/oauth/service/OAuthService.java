package uplord.uplordapi.oauth.service;

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
import uplord.uplordapi.oauth.vo.KakaoAccount;
import uplord.uplordapi.oauth.vo.KakaoUserVO;
import uplord.uplordapi.oauth.vo.KaKaoProperties;
import uplord.uplordapi.dto.UserDTO;

import java.io.*;
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

    private KakaoUserVO getKakaoUser(String token) throws IOException {
        String reqURL = "https://kapi.kakao.com/v2/user/me";

        //access_token을 이용하여 사용자 정보 조회
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization","Bearer " + token);

        return restTemplate.postForObject(reqURL,new HttpEntity<>(headers), KakaoUserVO.class);
    }

    public String authenticateUser(String token) throws IOException {

        KakaoUserVO kakaoUserInfo = getKakaoUser(token);

        String snsId = kakaoUserInfo.getId().toString();
        KakaoAccount kakaoAccount = kakaoUserInfo.getKakao_account();
        KaKaoProperties kakaoProperties = kakaoUserInfo.getProperties();

        // 등록된 유저가 아니라면, 신규 삽입
        if (dao.findUserBySnsId(snsId) == null) {
            UserDTO user = UserDTO.builder()
                    .snsType("KAKAO")
                    .snsId(snsId)
                    .userEmail(kakaoAccount.getEmail())
                    .userName(kakaoProperties.getNickname())
                    .build();

            dao.createUser(user);
        }

        UserDTO user = dao.findUserBySnsId(snsId);
        // TODO 토큰 발급
        return jwtTokenProvider.createToken(user.getUsername());
    }
}
