package uplord.uplordapi.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import uplord.uplordapi.service.OAuthService;

@RestController
@RequiredArgsConstructor
//@RequestMapping("/oauth")
public class OAuthController {

    private OAuthService service;

    @ResponseBody
    @GetMapping("/oauth")
    public void getAuthorizationCode(@RequestParam ("code") String code){

        String access_Token = service.getKakaoAccessToken(code);
        service.createKakaoUser(access_Token);
    }
}
