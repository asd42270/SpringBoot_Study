package org.example.hellospringboot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.hellospringboot.model.UserRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloSpringbootApplicationTests {
	@Autowired
	private  ObjectMapper objectMapper;

	@Test
	void contextLoads() throws JsonProcessingException {
		var user = new UserRequest();
		user.setName("홍길동");
		user.setUserAge(20);
		user.setEmail("hong@gmail.com");
		user.setIsKorean(true);

		var json = objectMapper.writeValueAsString(user);
		System.out.println(json);

		var dto = objectMapper.readValue(json, UserRequest.class);
		System.out.println(dto);
	}
}
