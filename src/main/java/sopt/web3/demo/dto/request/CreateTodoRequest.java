package sopt.web3.demo.dto.request;

import java.util.List;

public record CreateTodoRequest(
        List<String> todos
) {
}
