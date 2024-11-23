package sopt.web3.demo.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

public record SuccessResponse<T>(
        boolean success,
        String message,
        @JsonInclude(value = NON_NULL) T data
) implements BaseResponse {

    public static <T> SuccessResponse<T> success(String message, T data) {
        return new SuccessResponse<>(true, message, data);
    }

    public static SuccessResponse<?> success(String message) {
        return new SuccessResponse<>(true, message, null);
    }
}
