package com.horsesf.bootlanuch;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thymeleaf.templateresolver.UrlTemplateResolver;

import com.horsesf.bootlanuch.controller.ArticleController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ArticleControllerTests {
    private static MockMvc mockMvc;

    @BeforeAll
    static void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(new ArticleController()).build();
    }

    @Test
    public void saveArticle() throws Exception{

        String article = " {\n" +
            " \"id\": 1, \n" +
            " \"author\": \"horsesf\", \n" +
            " \"title\": \"t1\", \n" +
            " \"content\": \"c\", \n" +
            " \"createTime\": \"2017-07-16 05:23:34\", \n" +
            " \"reader\": [{\"name\":\"horsesf\", \"age\":18}, {\"name\":\"kobe\", \"age\":37}] \n" +
            "}";

        // TODO error
        MvcResult mvcResult = mockMvc.perform(
            MockMvcRequestBuilders
                .request(HttpMethod.POST, "/rest/articles")
                .contentType("application/json")
                .content(article)
        )
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$data.author").value("horsesf"))
        .andExpect(MockMvcResultMatchers.jsonPath("$data.reader[0].age").value(18))
        // TODO print()方法无效
        // .andDo(print())
        .andReturn();

        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        log.info(mvcResult.getResponse().getContentAsString());

    }
}
