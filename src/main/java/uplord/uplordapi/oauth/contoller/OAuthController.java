package uplord.uplordapi.oauth.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uplord.uplordapi.oauth.service.OAuthService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/oauth")
public class OAuthController {

    private final OAuthService service;

    @ResponseBody
    @PostMapping("/kakao")
    public ResponseEntity<Map<String, String>> getAuthorizationCode(@RequestBody Map<String, String> body){

        Map<String, String> result = new HashMap<>();
        try {
            String authCode = body.get("code");

            String access_Token = service.getKakaoAccessToken(authCode);
            String token = service.createKakaoUser(access_Token);

            result.put("token", token);

            return ResponseEntity.ok(result);


        }catch (IOException ioe){
            String msg = "카카오톡 API 통신 중 오류가 발생했습니다.";
            result.put("msg", msg);
            return ResponseEntity.internalServerError()
                    .body(result);


        }catch (Exception e) {
            String msg = e.getMessage();
            result.put("msg", msg);
            return ResponseEntity.internalServerError()
                    .body(result);
        }
    }
}
