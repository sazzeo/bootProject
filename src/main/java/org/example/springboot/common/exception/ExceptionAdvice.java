package org.example.springboot.common.exception;


import org.example.springboot.common.code.ResponseCode;
import org.example.springboot.common.response.CustomResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;


@RestControllerAdvice(basePackages = "org.example.springboot")
public class ExceptionAdvice {

    //데이터 없음 에러
    @ResponseStatus(code = HttpStatus.BAD_REQUEST) //400에러
    @ExceptionHandler(HandleableException.class)
    public ResponseEntity<Map> handleableExceptionProcess(HandleableException e , Model model) {
        return CustomResponseEntity.error(e.getResponseCode());

    }


    //밸리데이터 오류 에러
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map> validError(MethodArgumentNotValidException e) {
        return CustomResponseEntity.error(e.getBindingResult().getAllErrors().get(0).getDefaultMessage() , ResponseCode.BAD_REQUEST);

    }

}
