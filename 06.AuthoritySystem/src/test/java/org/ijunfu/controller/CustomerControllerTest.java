package org.ijunfu.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ qq.com>
 * @date 2022/02/06 23:04
 * @version 1.0.0
 *
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
class CustomerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void query() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/customer/query"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void queryForName() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/customer/query?name=子"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void queryForPhone() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/customer/query?phone=17"))
                .andDo(MockMvcResultHandlers.print());
    }
}