package com.blazings.suanfa.springboot.swagger.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class SwaggerControllerTest {
  MockMvc mockMvc;
  @Autowired WebApplicationContext webApplicationContext;

    @BeforeEach
    void setUp() {
    MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void swagger() {
    }

    @Test
    void swaggerListUser() {
    }
}