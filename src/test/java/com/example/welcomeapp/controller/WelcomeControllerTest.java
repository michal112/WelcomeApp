package com.example.welcomeapp.controller;

import com.example.welcomeapp.service.WelcomeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(WelcomeController.class)
@Import(WelcomeControllerTest.ContextConfiguration.class)
class WelcomeControllerTest {

    @TestConfiguration
    static class ContextConfiguration {

        @Bean
        WelcomeService welcomeService() {
            var mock = Mockito.mock(WelcomeService.class);
            when(mock.welcome()).thenReturn("hello world");
            return mock;
        }
    }

    @Autowired
    MockMvc mockMvc;

    @Test
    void welcomeTest() throws Exception {
        //given
        var expected = "hello world";
        //when
        mockMvc.perform(get("/welcome"))
                .andDo(print())
        //then
                .andExpect(status().isOk())
                .andExpect(content().string(expected)).andReturn();
    }

}