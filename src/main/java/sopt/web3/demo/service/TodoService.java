package sopt.web3.demo.service;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;
import sopt.web3.demo.dto.request.CreateTodoRequest;
import sopt.web3.demo.dto.request.UpdateTodoRequest;
import sopt.web3.demo.dto.response.TodoListTodayGetResponse;
import sopt.web3.demo.entity.Member;
import sopt.web3.demo.entity.Todo;
import sopt.web3.demo.entity.TodoList;
import sopt.web3.demo.repository.MemberRepository;
import sopt.web3.demo.repository.TodoListRepository;
import sopt.web3.demo.repository.TodoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class TodoService {

    private final TodoRepository todoRepository;
    private final TodoListRepository todoListRepository;
    private final MemberRepository memberRepository;

    public TodoService(TodoRepository todoRepository, TodoListRepository todoListRepository, MemberRepository memberRepository) {
        this.todoRepository = todoRepository;
        this.todoListRepository = todoListRepository;
        this.memberRepository = memberRepository;
    }

    public TodoListTodayGetResponse getTodayTodo(long memberId, LocalDate date) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("노 멤버"));
        Optional<TodoList> todoList = todoListRepository.findByMemberAndDate(member, date);
        List<Todo> todos = null;
        if (todoList.isPresent()){
            todos = todoRepository.findAllByTodoList(todoList.get());
        }
        return TodoListTodayGetResponse.from(todos);
    }

    public void createTodo(long memberId, LocalDate date, CreateTodoRequest request) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("노 멤버"));
        Optional<TodoList> todoListOptional = todoListRepository.findByMemberAndDate(member, date);
        List<Todo> todos = null;
        TodoList todoList = null;
        if (todoListOptional.isEmpty()){
            todoList = todoListRepository.save(TodoList.of(date, null, null, null, false));
        }else {
            todoList = todoListOptional.get();
        }
        for (String content : request.todos()) {
            todoRepository.save(Todo.of(content, todoList));
        }
    }

    @Transactional
    public void updateTodo(long memberId, UpdateTodoRequest request) {
        for(Long id: request.todoIds()){
            Todo todo = todoRepository.findById(id).get();
            todo.updateState();
        }
    }
}
