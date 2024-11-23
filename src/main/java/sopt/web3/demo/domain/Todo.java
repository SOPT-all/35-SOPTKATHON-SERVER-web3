package sopt.web3.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private final String content;
    private final boolean complete;

    private final TodoList todoList;

    private Todo(String content, boolean complete, TodoList todoList) {
        this.content = content;
        this.complete = complete;
        this.todoList = todoList;
    }

    public static Todo



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
}
