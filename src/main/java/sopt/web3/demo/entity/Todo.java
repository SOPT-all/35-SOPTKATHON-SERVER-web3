package sopt.web3.demo.entity;

import jakarta.persistence.*;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String content;
    private boolean complete;

    @ManyToOne
    private  TodoList todoList;

    private Todo(String content, boolean complete, TodoList todoList) {
        this.content = content;
        this.complete = complete;
        this.todoList = todoList;
    }

    public Todo() {
    }

    public static Todo of(String content, TodoList todoList) {
        return new Todo(content, false, todoList);
    }



    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public boolean isComplete() {
        return complete;
    }

    public TodoList getTodoList() {
        return todoList;
    }
    public void updateState(){
        this.complete = true;
    }
}
