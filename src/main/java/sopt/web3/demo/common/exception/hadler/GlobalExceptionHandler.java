package sopt.web3.demo.common.exception.hadler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sopt.market.common.dto.BaseResponse;
import sopt.market.common.dto.ErrorResponse;
import sopt.market.common.exception.errorcode.ErrorCode;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class.getName());

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponse> Exception(Exception exception) {
        logger.log(Level.WARNING,exception.getMessage());
        ErrorCode errorCode = ErrorCode.SERVER_ERROR;
        return ResponseEntity.status(errorCode.getHttpStatus()).body(ErrorResponse.of(errorCode.getMessage()));
    }
}
