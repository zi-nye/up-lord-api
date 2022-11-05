package uplord.uplordapi.oauth.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uplord.uplordapi.oauth.service.OAuthService;

@RestController
@RequiredArgsConstructor
//@RequestMapping("/login")
public class OAuthController {

    private OAuthService service;

    @ResponseBody
    @GetMapping("/oauth")
    public void getAuthorizationCode(@RequestParam ("code") String code){

        String access_Token = service.getKakaoAccessToken(code);
        service.createKakaoUser(access_Token);
    }
}
