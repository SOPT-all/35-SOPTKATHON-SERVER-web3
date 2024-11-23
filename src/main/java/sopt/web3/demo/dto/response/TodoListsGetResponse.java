package sopt.web3.demo.dto.request;

import sopt.web3.demo.entity.TodoList;

import java.sql.Date;
import java.util.List;


public record TodoListsGetResponse(List<TodoListResponse> todoLists) {

    public record TodoListResponse(Date date, int level, int num_completed, int num_all) { }

    public static TodoListsGetResponse of(List<TodoList> todoLists) {

        List<TodoListResponse> diaryResponseList = todoLists.stream()
                .map(todoList -> new TodoListResponse(
                        todoList.getDate(),
                        todoList.getLevel(),
                        todoList.getNumCompleted(),
                        todoList.getNumAll()))
                .toList();

        return new TodoListsGetResponse(diaryResponseList);
    }
}