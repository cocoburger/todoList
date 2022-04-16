package com.example.demo.controller;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("todo")
public class TodoController {
	
	//@RequiredArgsConstructor lombok 어노테이션을 사용하면 더 편리
	
	private final TodoService todoService;

	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}


}
