package sopt.web3.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import sopt.web3.demo.common.dto.SuccessResponse;
import sopt.web3.demo.dto.response.TodoListsGetResponse;
import sopt.web3.demo.service.TodoListService;
import static sopt.web3.demo.common.messages.SuccessMessages.GET_TODOLISTS;
import static sopt.web3.demo.common.dto.SuccessResponse.success;

@RequestMapping("/api")
public class TodoListController {

    private final TodoListService todoListService;

    public TodoListController(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    @GetMapping("/v1/member/todolist")
    public ResponseEntity<SuccessResponse<TodoListsGetResponse>> getTodoLists(
            @RequestHeader long memberId
    ) {
        return ResponseEntity.ok(success(GET_TODOLISTS.getMessage(), todoListService.getTodoLists(memberId)));
    }
}