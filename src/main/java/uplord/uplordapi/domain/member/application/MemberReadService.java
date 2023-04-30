package uplord.uplordapi.domain.member.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uplord.uplordapi.domain.member.dao.MemberDao;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberReadService {
    final private MemberDao memberDao;

    public List<Long> findAllMemberIdx() {
        return memberDao.findAllMemberIdx();
    }
}
