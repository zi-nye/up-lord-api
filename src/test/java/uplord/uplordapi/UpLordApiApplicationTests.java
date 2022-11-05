package uplord.uplordapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uplord.uplordapi.sysManange.service.CellService;
import uplord.uplordapi.sysManange.service.impl.CellServiceImpl;
import uplord.uplordapi.sysManange.vo.CellVO;

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
        List<CellVO> list = service.findList(new CellVO());

        //then
        for (CellVO cvo : list ) {
            System.out.println(cvo.getCellLeaderNm());
            System.out.println(cvo.getCellNm());
            System.out.println(cvo.getCellGroupPlace());
        }

    }

}
