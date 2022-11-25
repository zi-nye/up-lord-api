package uplord.uplordapi.oauth.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uplord.uplordapi.oauth.service.OAuthService;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/oauth")
public class OAuthController {

    private final OAuthService service;

    @ResponseBody
    @PostMapping("/kakao")
    public String getAuthorizationCode(@RequestBody Map<String, String> body){
        // TODO 서비스에서 하도록 할 것.
            // 인증코드 가지고 토큰 받기 😃
            // 토큰 받은 것으로 유저 조회하기
            // 카카오톡 유저 조회 API 조회
            // 조회한 데이터를 참고하여 토큰 발급하기
                // 이미 입력된 유저라면, 그냥 토큰 주기
                // 아니라면, 신규로 삽입하고 토큰 주기

        //TODO
        // API 요청하는 모듈 만들기: common 패키지 아래 패키지 하나 더 만들고 그 아래에 만들기
        // MyBatis 생성

        String authCode = body.get("code");

        String access_Token = service.getKakaoAccessToken(authCode);
        String token = service.createKakaoUser(access_Token);

        return token;
    }
}
