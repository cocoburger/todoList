package com.example.demo.dto;

import com.example.demo.model.TodoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TodoDTO {
	private String id;
	private String title;
	private boolean done;

	//보안상 userId는 숨기는 것이 맞다. 그래서 DTO에는 userId를 만들지 않는다.
	public TodoDTO(final TodoEntity entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.done = entity.isDone();
	}

	//response시에 캡슐화하거나 추가적인 정보를 함께 반환하려고 DTO를 사용한다.
	//컨트롤러는 사용자에게서 TodoDTO를 요청 바디로 넘겨받고 이를 TodoEntity로 변환해 저장해야한다.
	public static TodoEntity todoEntity (TodoDTO dto) {
		return TodoEntity.builder()
				.id(dto.getId())
				.title(dto.getTitle())
				.done(dto.done)
				.build();
	}
}
