package uplord.uplordapi.oauth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uplord.uplordapi.oauth.dao.OauthDAO;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final OauthDAO dao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = dao.findUserByUserId(username);

        if(userDetails == null) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }

        return dao.findUserBySnsId(username);
    }
}
