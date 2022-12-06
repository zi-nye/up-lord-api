package uplord.uplordapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uplord.uplordapi.sysManange.service.impl.CellServiceImpl;
import uplord.uplordapi.dto.CellDTO;

import java.util.List;

@SpringBootTest
class UpLordApiApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private CellServiceImpl service;

    @Test
    void 셀목록_조회(){
        //given

        //when
        List<CellDTO> list = service.findList(new CellDTO());

        //then
        for (CellDTO cvo : list ) {
            System.out.println(cvo.getCellLeaderNm());
            System.out.println(cvo.getCellNm());
            System.out.println(cvo.getCellGroupPlace());
        }

    }

}
