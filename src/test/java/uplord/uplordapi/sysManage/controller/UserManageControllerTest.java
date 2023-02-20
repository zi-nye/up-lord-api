package uplord.uplordapi.sysManage.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import uplord.uplordapi.dto.UserDTO;
import uplord.uplordapi.dto.UserUpdateResultDTO;
import uplord.uplordapi.sysManage.service.impl.UserManageServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserManageControllerTest {

    @InjectMocks
    private UserManageController userManageController;
    @Mock
    private UserManageServiceImpl userManageService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(userManageController).build();
    }

    @Test
    @DisplayName("사용자 목록 조회 컨트롤러 테스트")
    void findListControllerTest() throws Exception {
        // given
        doReturn(makeUserList()).when(userManageService).findList();

        // when
        ResultActions resultActions = mockMvc.perform(
                get("/sysManage/userManage"));

        // then
        MvcResult mvcResult = resultActions.andExpect(status().isOk()).andReturn();
        String json = mvcResult.getResponse().getContentAsString();
        assertThat(json).contains("yeasung67@gmail.com");
    }

    @Test
    @DisplayName("사용자 권한 업데이트 컨트롤러 테스트")
    void updateControllerTest() throws Exception {
        // given
        List<UserDTO> updateRequest = makeUserList();
        updateUseYn(updateRequest);
        List<UserUpdateResultDTO> response = List.of(UserUpdateResultDTO.builder()
                                                                        .userId("yeasung67@gmail.com")
                                                                        .useYn("Y")
                                                                        .build(),
                                                     UserUpdateResultDTO.builder()
                                                                        .userId("hst@gmail.com")
                                                                        .useYn(null)
                                                                        .build()
        );
        doReturn(response).when(userManageService).update(anyList());

        // when
        ResultActions resultActions = mockMvc.perform(
                put("/sysManage/userManage")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(updateRequest))
        );

        // then
        MvcResult mvcResult = resultActions.andExpect(status().isOk()).andReturn();
        String json = mvcResult.getResponse().getContentAsString();
        assertThat(json).contains("\"userId\":\"yeasung67@gmail.com\",\"useYn\":\"Y\"");
        assertThat(json).contains("\"userId\":\"hst@gmail.com\",\"useYn\":null");
    }

    @Test
    @DisplayName("사용자 권한 업데이트 실패 컨트롤러 테스트")
    void updateFailControllerTest() {

    }

    private List<UserDTO> makeUserList() {
        List<UserDTO> users = new ArrayList<>();
        users.add(UserDTO.builder()
                         .userId("yeasung67@gmail.com")
                         .userName("고예성")
                         .useYn(null)
                         .build());
        users.add(UserDTO.builder()
                         .userId("hst@gmail.com")
                         .userName("황성태")
                         .useYn(null)
                         .build());

        return users;
    }

    private void updateUseYn(List<UserDTO> param) {
        param.set(0, UserDTO.builder()
                            .userId("yeasung67@gmail.com")
                            .userName("고예성")
                            .useYn("Y")
                            .build());
    }
}
