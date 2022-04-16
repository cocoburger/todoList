package com.example.demo.persistence;

import com.example.demo.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, String> {
	//?1은 메서드의 매개변수의 순서 위치이다.

	//*는 사용시 에러가 발생한다. from 뒤에 해당 엔티티와  [*] 대신 약어를 사용해준다.
	@Query("select t from TodoEntity t where t.userId = ?1")
	List<TodoEntity> findByUserId(String userId);

}


