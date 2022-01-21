package org.ijunfu.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.HeaderResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/21 23:34
 * @version 1.0.0
 *
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // 定义Web环境
@AutoConfigureMockMvc   // 开启虚拟MVC
class BookControllerTest {

    @Test
    void testStatus(@Autowired MockMvc mvc) throws Exception {
        // 1. 定义请求地址
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books/all");
        // 2. 执行请求
        ResultActions actions = mvc.perform(builder);

        // 3. 预计本次执行成功，状态值为200
        StatusResultMatchers status = MockMvcResultMatchers.status();
        ResultMatcher ok = status.isOk();

        // 4. 与期望值对比
        actions.andExpect(ok);
    }

    @Test
    void testBody(@Autowired MockMvc mvc) throws Exception {
        // 1. 定义请求地址
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books/all");
        // 2. 执行请求
        ResultActions actions = mvc.perform(builder);

        // 3. 预计本次调用返回值
        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher ret = content.string("query all books");

        // 4. 与期望值对比
        actions.andExpect(ret);
    }

    @Test
    void testJSONBody(@Autowired MockMvc mvc) throws Exception {
        // 1. 定义请求地址
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        // 2. 执行请求
        ResultActions actions = mvc.perform(builder);

        // 3. 预计本次调用返回值
        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher ret = content.json("{\"id\": 100827,\n" + "\"name\": \"SpringBoot 2.x1\",\n" + "\"author\": \"SpringBoot\",\n" + "\"type\": \"Java\",\n" + "\"remarks\": \"官方出品，盗版必究\"}");

        // 4. 与期望值对比
        actions.andExpect(ret);
    }

    @Test
    void testContentType(@Autowired MockMvc mvc) throws Exception {
        // 1. 定义请求地址
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        // 2. 执行请求
        ResultActions actions = mvc.perform(builder);

        // 3. 预计本次调用返回值
        HeaderResultMatchers header = MockMvcResultMatchers.header();
        ResultMatcher contentType = header.string("Content-Type", "application/json");

        // 4. 与期望值对比
        actions.andExpect(contentType);
    }
}