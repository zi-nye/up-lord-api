package uplord.uplordapi.event.service;

import uplord.uplordapi.dto.MemberInfoDTO;

import java.util.List;

public interface BirthdayService {
    List<MemberInfoDTO> findList();
}
