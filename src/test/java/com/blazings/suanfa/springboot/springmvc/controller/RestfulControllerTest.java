package com.blazings.suanfa.springboot.springmvc.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
@SpringBootTest
class RestfulControllerTest {
	@Autowired
	WebApplicationContext webApplicationContext;

	MockMvc mockMvc;

	@BeforeEach
	void setUp() {
		mockMvc=MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@AfterEach
	void tearDown() {
	}
}