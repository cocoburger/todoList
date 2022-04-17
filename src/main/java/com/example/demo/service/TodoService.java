package com.example.demo.service;

import com.example.demo.dto.TodoDTO;
import com.example.demo.model.TodoEntity;
import com.example.demo.persistence.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TodoService {



	private final TodoRepository repository;

	public TodoService(TodoRepository repository) {
		this.repository = repository;
	}

	public List<TodoEntity> create (final TodoEntity entity) {
		if(entity == null ) {
			log.warn("Entity cannot be null.");
			throw new RuntimeException("Entity cannot be null.");
		}

		if(entity.getUserId() == null) {
			log.warn("Unknown user.");
			throw new RuntimeException("Unknown user.");
		}
		repository.save(entity);
		log.info("Entity Id : {} is saved", entity.getId());

		return repository.findByUserId(entity.getUserId());
	}

	public List<TodoEntity> retrieve(final String userId) {
		return repository.findByUserId(userId);
	}



	// 다른 부분에서도 사용할 거니깐 private로
	private void validate(final TodoEntity entity) {
		if(entity == null) {
			log.warn("Entity cannot be null.");
			throw new RuntimeException("Entity cannot be null.");
		}
		if (entity. getUserId() == null) {
			log.warn("Unknown user.");
			throw new RuntimeException("Entity cannot be null.");
		}
	}

	public List<TodoEntity> update(final TodoEntity entity) {
		// 1. 저장할 엔티티가 유효한지 확인한다. 이 메서드는 2.3.1 Create todo에서 구현했다.
		validate(entity);

		// 2. 넘겨받은 엔티티 ID를 이용해 TodoEntitiy를 가져온다. 존재하지 않는 엔티티는 업데이트할 수 없기 때문이다.
		final Optional<TodoEntity> original = repository.findById(entity.getId());

		original.ifPresent(todo -> {
			// 3. 반환된 TodoEntitiy가 존재하면 값을 새 entity 값으로 덮어 씌운다.
			todo.setTitle(entity.getTitle());
			todo.setDone(entity.isDone());

			// 4. 데이터베이스에 새 값을 저장한다.
			repository.save(todo);
		});

		// 2.3.2 Retrieve Todo에서 만든 메서드를 이용해 사용자의 모든 Todo 리스트를 리턴한다.
		return retrieve(entity.getUserId());
	}
}
