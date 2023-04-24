package com.univer.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(CustomException.class)
    public String handlerCustomException(){
        System.out.println("привіт");
        return "/WEB-INF/error/404.jsp";
    }


}
