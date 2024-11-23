package sopt.web3.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import sopt.web3.demo.entity.Todo;
import sopt.web3.demo.entity.TodoList;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findAllByTodoList(TodoList todoList);
}
