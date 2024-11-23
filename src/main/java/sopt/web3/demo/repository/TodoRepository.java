package sopt.web3.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.web3.demo.domain.Todo;
import sopt.web3.demo.domain.TodoList;
import sopt.web3.demo.service.TodoService;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findAllByTodoList(TodoList todoList);
}
