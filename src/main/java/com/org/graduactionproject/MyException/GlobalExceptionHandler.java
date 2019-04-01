package com.org.graduactionproject.MyException;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
//    @ExceptionHandler(value = Exception.class)
//    @ResponseBody
//    public RspBean jsonExceptionHandler(HttpServletRequest request, Exception e) {
//        return new RspBean().fail(e.getMessage());
//    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public RspBean runtimeExceptionHandler(RuntimeException e) {
        return new RspBean().fail(e.getMessage());
    }

    //空指针异常
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public RspBean nullPointerExceptionHandler(NullPointerException e) {
        return new RspBean().fail(e.getMessage());
    }


//    //400错误
//    @ExceptionHandler({HttpMessageNotReadableException.class})
//    @ResponseBody
//    public RspBean requestNotReadable(HttpMessageNotReadableException ex){
//        System.out.println("400..requestNotReadable");
//        ex.printStackTrace();
//        return new RspBean().fail(e.getMessage());
//    }

}
