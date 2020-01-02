package com.mybatisplus.demo.config;

import com.mybatisplus.demo.model.base.Result;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

  @ExceptionHandler({IllegalArgumentException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public Result badRequestException(IllegalArgumentException exception) {
    Result result = new Result();
    result.setCode(HttpStatus.BAD_REQUEST.value());
    result.setMsg(exception.getMessage());

    return result;
  }
}
