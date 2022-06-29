package kr.co.memberservice.error.handler;

import kr.co.memberservice.error.exception.BusinessLogicException;
import kr.co.memberservice.error.model.ResponseFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {BusinessLogicException.class, RuntimeException.class})
    public ResponseEntity handleRuntimeException(RuntimeException e){
        ResponseFormat responseFormat = ResponseFormat.fail(e.getMessage());
        return new ResponseEntity(responseFormat, HttpStatus.OK);
    }
}
