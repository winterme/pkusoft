package com.zzq.config.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * created with IntelliJ IDEA.
 * author: fxbin
 * date: 2018/9/9
 * time: 12:12
 * description:
 */
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(Exception.class)
    public Result jsonErrorHandler(HttpServletRequest req, Exception e){
        return ResultGenerator.genFailResult(e.getMessage());
    }

//    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e, HttpServletRequest req){

//        //使用HttpServletRequest中的header检测请求是否为ajax, 如果是ajax则返回json, 如果为非ajax则返回view(即ModelAndView)
//        String contentTypeHeader = req.getHeader("Content-Type");
//        String acceptHeader = req.getHeader("Accept");
//        String xRequestedWith = req.getHeader("X-Requested-With");
//        if ((contentTypeHeader != null && contentTypeHeader.contains("application/json"))
//                || (acceptHeader != null && acceptHeader.contains("application/json"))
//                || "XMLHttpRequest".equalsIgnoreCase(xRequestedWith)) {
//            return ResultGenerator.genFailResult(e.getMessage());
//        } else {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", e.getMessage());
        modelAndView.addObject("url", req.getRequestURL());
        modelAndView.addObject("stackTrace", e.getStackTrace());
        modelAndView.setViewName("error");
        return modelAndView;
//        }
    }

}
