package com.example.demo.controller;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.TestRequestBodyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("test") //리소스
public class TestController {
	@GetMapping("/testRequestBody")
	public String testControllerRequestBody(@RequestBody TestRequestBodyDTO testRequestBodyDTO) {
		return "Hello World ID " + testRequestBodyDTO.getId() + "Message : " +
				testRequestBodyDTO.getMessage();
	}
	@GetMapping
	public String testController() {
		return "hello world";
	}

	@GetMapping("/testGetMapping")
	public String testControllerWithPath() {
		return "세상아 내가 나간다. 길을 비켜라";
	}

	@GetMapping("/{id}")
	public String testControllerWithPathVariables(@PathVariable(required = false) int id) {
		return "세상이 그리 넓다는 제가 한번 가보죠 No." + id;
	}

	@GetMapping("/testRequestParam")
	public String testControllerRequestParam(@RequestParam(required = false) int id) {
		return "여보세요. 내가 몇 번째 전화 거는 줄 알아?" + id;

	}

	@GetMapping("/testResponseBody")
	public ResponseDTO<String> testControllerResponseBody() {
		List<String> list = new ArrayList<>();
		list.add("안녕하세요. 반가워요 잘지내요 다시 만나요~");
		ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
		response.getError();
		return response;
	}

	@GetMapping("/testResponseEntity")
	public ResponseEntity<?> testControllerResponseEntity() {
		List<String> list = new ArrayList<>();
		list.add("가즈아~~ 떡상 ㅎㅎㅎㅎ");
		ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
		return  ResponseEntity.ok().body(response);
	//	return  ResponseEntity.badRequest().body(response);
	}
}
