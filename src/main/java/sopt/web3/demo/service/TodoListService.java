package sopt.web3.demo.service;

import org.springframework.stereotype.Service;
import sopt.web3.demo.dto.response.TodoListsGetResponse;
import sopt.web3.demo.entity.TodoList;
import sopt.web3.demo.repository.TodoListRepository;

import java.util.List;

@Service
public class TodoListService {
    private final TodoListRepository todoListRepository;

    public TodoListService(TodoListRepository todoListRepository){
        this.todoListRepository = todoListRepository;
    }

    public TodoListsGetResponse getTodoLists(long memberId){
        List<TodoList> todoLists = todoListRepository.findByMemberId(memberId);
        return TodoListsGetResponse.of(todoLists);
    }
}
