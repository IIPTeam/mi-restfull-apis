package org.mi.user.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.aspectj.util.FileUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mi.user.Application;
import org.mockito.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureTestDatabase
public class UserControllerTest {
	private MockMvc mvc;

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	UserController userController;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(userController).build();
	}

	@Test
	public void testPostUser() throws Exception {
		ClassPathResource classPathResource = new ClassPathResource("org/mi/user/stub/post-user.json");
		byte[] readAsByteArray = FileUtil.readAsByteArray(classPathResource.getInputStream());

		mvc.perform(post("/process/user").contentType(MediaType.APPLICATION_JSON_UTF8).accept(MediaType.APPLICATION_JSON_UTF8)
				.content(new String(readAsByteArray, "utf-8"))).andExpect(status().isOk())
				.andExpect(content().string(containsString("userID")));
	}
	
	@Test
	public void testPutUser(){
		//TODO
	}
	
	@Test
	public void testListUser(){
		//TODO
	}
	
	@Test
	public void testGetUserById(){
		
	}

}
