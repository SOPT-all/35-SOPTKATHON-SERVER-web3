package sopt.web3.demo.dto.response;

import sopt.web3.demo.entity.Todo;

import java.util.List;

public record TodoListTodayGetResponse(
        boolean completed,
        List<TodoTodayGetResponse> todoTodayGetResponseList
){

    public static TodoListTodayGetResponse from(final List<Todo> todos,final boolean completed){
        return new TodoListTodayGetResponse(completed,todos.stream().map(TodoTodayGetResponse::from).toList());
    }

    public record TodoTodayGetResponse(
           long id,
           String content
    ){
        public static TodoTodayGetResponse from(final Todo todo){
            return new TodoTodayGetResponse(todo.getId(), todo.getContent());
        }
    }
}
