package com.yaolong.web.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author yaoLong
 * @date 2019/10/5  16:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    /**
     * 构建mvc测试环境
     */
    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }


    @Test
    public void whenQuerySuccess() throws Exception {

        mockMvc
                .perform(MockMvcRequestBuilders.get("/user")  //构建一个请求
                        .param("size", "10")
                        .param("page", "3")
                        .param("sort", "username,desc")
                        .contentType(MediaType.APPLICATION_PROBLEM_JSON_UTF8))   //请求数据的类型
                .andExpect(MockMvcResultMatchers.status().isOk())  //请求的期望：是否成功
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3)); //请求的期望：是否为一个长度为三的集合

    }

    @Test
    public void whenGetInfoSuccess() throws Exception {

        String result = mockMvc
                .perform(MockMvcRequestBuilders.get("/user/1")  //构建一个请求
                        //                        .param("size","10")
                        //                        .param("page","3")
                        //                        .param("sort","username,desc")
                        .contentType(MediaType.APPLICATION_PROBLEM_JSON_UTF8))   //请求数据的类型
                .andExpect(MockMvcResultMatchers.status().isOk())  //请求的期望：是否成功
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("yao_long"))//请求的期望：是否为一个长度为三的集合
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

    @Test
    public void whenGetInfoFail() throws Exception {
        String result = mockMvc
                .perform(MockMvcRequestBuilders.get("/user/a")
                        .contentType(MediaType.APPLICATION_PROBLEM_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError())
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);

    }

    @Test
    public void whenCreateSuccess() throws Exception {
        Date date = new Date();

        String content = "{\"username\":\"admin\",\"password\":null,\"birthday\":" + date.getTime() + "}";
        String result = mockMvc
                .perform(MockMvcRequestBuilders.post("/user")
                        .contentType(MediaType.APPLICATION_PROBLEM_JSON_UTF8)
                        .content(content))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
                .andReturn().getRequest().getContentAsString();

        System.out.println(result);

    }

    @Test
    public void whenUpdateSuccess() throws Exception {
        Date date = new Date(LocalDateTime.now().plusYears(1).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());

        String content = "{\"id\":\"1\",\"username\":\"admin\",\"password\":123,\"birthday\":" + date.getTime() + "}";
        String result = mockMvc
                .perform(MockMvcRequestBuilders.put("/user/1")
                        .contentType(MediaType.APPLICATION_PROBLEM_JSON_UTF8)
                        .content(content))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
                .andReturn().getRequest().getContentAsString();

        System.out.println(result);

    }


    @Test
    public void whenDeleteSuccess() throws Exception {

        mockMvc
                .perform(MockMvcRequestBuilders.delete("/user/4")
                        .contentType(MediaType.APPLICATION_PROBLEM_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk());


    }
}
