package sopt.web3.demo.dto.request;

import java.util.List;

public record UpdateTodoRequest(
        List<Long> todoIds
) {
}