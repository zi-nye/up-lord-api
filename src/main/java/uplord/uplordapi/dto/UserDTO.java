package uplord.uplordapi.dto;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import uplord.uplordapi.common.domain.UpdateDetect;

import java.util.Collection;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements UserDetails, UpdateDetect {
    private String userId;
    private String userName;
    private String userEmail;
    private String password;
    private String userPhone;
    private String userBirth;
    private String userNickname;
    private String gender;
    private String snsType;
    private String snsId;
    private String authCd;
    private String cellCd;
    private String useYn;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return userId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
