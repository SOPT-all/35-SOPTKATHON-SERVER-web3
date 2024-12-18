package sopt.web3.demo.dto.response;

import sopt.web3.demo.entity.TodoList;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


public record TodoListsGetResponse(List<TodoListResponse> todoLists) {

    public record TodoListResponse(LocalDate date, Integer level, Integer num_completed, Integer num_all) {

    }

    public static TodoListsGetResponse of(List<TodoList> todoLists) {

        List<TodoListResponse> diaryResponseList = todoLists.stream()
                .map(todoList -> new TodoListResponse(
                        todoList.getLocalDate(),
                        todoList.getLevel(),
                        todoList.getNumCompleted(),
                        todoList.getNumAll()))
                .toList();

        return new TodoListsGetResponse(diaryResponseList);
    }
}