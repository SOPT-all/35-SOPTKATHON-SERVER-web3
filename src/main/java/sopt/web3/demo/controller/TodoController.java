package sopt.web3.demo.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sopt.web3.demo.common.dto.SuccessResponse;
import sopt.web3.demo.dto.request.CreateTodoRequest;
import sopt.web3.demo.dto.request.UpdateTodoRequest;
import sopt.web3.demo.dto.response.TodoListTodayGetResponse;
import sopt.web3.demo.service.TodoService;

import java.time.LocalDate;

import static sopt.web3.demo.common.dto.SuccessResponse.success;
import static sopt.web3.demo.common.messages.SuccessMessages.GET_LEVEL;

@RestController
@RequestMapping("/api")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todo")
    public ResponseEntity<SuccessResponse<TodoListTodayGetResponse>> getTodayTodo(
            @RequestHeader long memberId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date
    ) {
        TodoListTodayGetResponse response = todoService.getTodayTodo(memberId,date);
        return ResponseEntity.ok(success(GET_LEVEL.getMessage(), response));
    }

    @PostMapping("/todo")
    public ResponseEntity<SuccessResponse<Void>> createTodo(
            @RequestHeader long memberId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
            @RequestBody CreateTodoRequest createTodoRequest
    ) {
        todoService.createTodo(memberId,date,createTodoRequest);
        return ResponseEntity.ok(success(GET_LEVEL.getMessage(), null));
    }

    @PatchMapping("/todo/check")
    public ResponseEntity<SuccessResponse<Void>> updateTodo(
            @RequestHeader long memberId,
            @RequestBody UpdateTodoRequest updateTodoRequest
    ) {
        todoService.updateTodo(memberId,updateTodoRequest);
        return ResponseEntity.ok(success(GET_LEVEL.getMessage(), null));
    }
}
