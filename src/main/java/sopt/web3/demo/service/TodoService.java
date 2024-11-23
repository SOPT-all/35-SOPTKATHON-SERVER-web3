package sopt.web3.demo.service;

import org.springframework.stereotype.Component;

import sopt.web3.demo.dto.request.CreateTodoRequest;
import sopt.web3.demo.dto.response.TodoListTodayGetResponse;
import sopt.web3.demo.entity.Todo;
import sopt.web3.demo.entity.TodoList;
import sopt.web3.demo.repository.TodoListRepository;
import sopt.web3.demo.repository.TodoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class TodoService {

    private final TodoRepository todoRepository;
    private final TodoListRepository todoListRepository;

    public TodoService(TodoRepository todoRepository, TodoListRepository todoListRepository) {
        this.todoRepository = todoRepository;
        this.todoListRepository = todoListRepository;
    }

    public TodoListTodayGetResponse getTodayTodo(long memberId, LocalDate date) {
        Optional<TodoList> todoList = todoListRepository.findByMemberIdAndDate(memberId, date);
        List<Todo> todos = null;
        if (todoList.isPresent()){
            todos = todoRepository.findAllByTodoList(todoList.get());
        }
        return TodoListTodayGetResponse.from(todos);
    }

    public void createTodo(long memberId, LocalDate date, CreateTodoRequest request) {
        Optional<TodoList> todoListOptional = todoListRepository.findByMemberIdAndDate(memberId, date);
        List<Todo> todos = null;
        TodoList todoList = null;
        if (todoListOptional.isEmpty()){
            todoList = todoListRepository.save(TodoList.of(date, null, null, null, false));
        }else {
            todoList = todoListOptional.get();
        }
        for (String content : request.todos()) {
            todoRepository.save()
        }
    }
}
