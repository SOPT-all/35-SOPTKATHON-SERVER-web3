package sopt.web3.demo.common.exception.errorcode;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

    SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,"서버 내부 오류입니다.")
    ;
    private final HttpStatus httpStatus;
    private final String message;

    ErrorCode(HttpStatus status, String message){
        this.httpStatus = status;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }
}
