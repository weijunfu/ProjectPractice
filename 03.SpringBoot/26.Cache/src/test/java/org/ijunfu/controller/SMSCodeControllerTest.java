package org.ijunfu.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/27 14:12
 * @version 1.0.0
 *
 */
@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureWebMvc
class SMSCodeControllerTest {

    @Test
    void test(@Autowired MockMvc mvc) throws Exception {
        String host = "http://localhost";

        String tel = "18888888888";

        MockHttpServletResponse response = mvc.perform(MockMvcRequestBuilders.get(host + "/sms?tel=" + tel)).andReturn().getResponse();
        int status = response.getStatus();
        assertEquals(200, status);

        String code = response.getContentAsString();
        log.info("{}", code);
    }
}