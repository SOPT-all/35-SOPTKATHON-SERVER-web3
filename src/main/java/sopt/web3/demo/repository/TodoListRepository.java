package sopt.web3.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.web3.demo.domain.TodoList;

public interface TodoListRepository extends JpaRepository<TodoList,Long> {
}
