package kosta.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kosta.web.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;

//@Controller
@RestController
@Slf4j
public class ResponseBodyController {
	
	@GetMapping(value="/responseBody.do", produces= {"text/plain;charset=UTF-8"})
	//@ResponseBody // return 값이 view가 아닌 HttpMessageConverter 동작에 의해 응답 body가 된다
	public String aa() {
		log.info("responseBody.do 요청됨");
		
		return "배고파 hungry";
	}
	
	/**
	 * 객체를 리턴하고 싶다면 아래 의존성 추가
		<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-databind</artifactId>
			<version>2.18.4</version>
		</dependency>
	 */
	@GetMapping("/responseBody2.do")
	//@ResponseBody
	public UserDTO bb() {
		log.info("responseBody2.do 요청됨");
		
		return UserDTO.builder()
				.id("ljg")
				.name("정건")
				.age(2)
				.addr("ㄴ")
				.build();
	}
}
