package uplord.uplordapi.event.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uplord.uplordapi.dto.MemberInfoDTO;
import uplord.uplordapi.event.dao.BirthdayDAO;
import uplord.uplordapi.event.service.BirthdayService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BirthdayServiceImpl implements BirthdayService {

    private final BirthdayDAO dao;
    @Override
    public List<MemberInfoDTO> findList() {
        return dao.findList();
    }
}
