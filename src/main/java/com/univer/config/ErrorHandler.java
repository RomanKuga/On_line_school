package com.univer.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(CustomException.class)
    public String handlerCustomException(){
        return "/WEB-INF/error/404.jsp";
    }


}
