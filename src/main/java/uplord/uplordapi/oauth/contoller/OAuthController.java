package uplord.uplordapi.oauth.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import uplord.uplordapi.dto.UserDTO;
import uplord.uplordapi.oauth.service.OAuthService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/oauth")
public class OAuthController {

    @Value("${jwt.header}")
    public static String AUTHORIZATION_HEADER;
    private final OAuthService service;

    @ResponseBody
    @PostMapping("/kakao")
    public ResponseEntity<Map<String, String>> getAuthorizationCode(@RequestBody Map<String, String> body){

        Map<String, String> result = new HashMap<>();
        try {
            String authCode = body.get("code");

            String access_Token = service.getKakaoAccessToken(authCode);
            String token = service.authenticateUser(access_Token);

            result.put("token", token);

            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (IOException ioe){

            String msg = "카카오톡 API 통신 중 오류가 발생했습니다.";
            result.put("msg", msg);
            return ResponseEntity.internalServerError()
                    .body(result);


        }catch (Exception e) {
            e.printStackTrace();
            String msg = e.getMessage();
            result.put("msg", msg);
            return ResponseEntity.internalServerError()
                    .body(result);
        }
    }

    @GetMapping("/test")
    public ResponseEntity<String> test(Authentication authentication){

        UserDTO user = (UserDTO) authentication.getPrincipal();

        return ResponseEntity.ok(user.getUserEmail()+ "님 하하하하하하하");
    }
}
