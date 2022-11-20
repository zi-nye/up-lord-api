package uplord.uplordapi.oauth.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DecodedToken {

    private String jwt;
    private Claims claims;
    private Date expiresAt;

}