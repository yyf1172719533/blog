package com.timain.web.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 异常处理控制器
 * @author yyf
 * @version 1.0
 * @date 2020/3/3 21:30
 */
@ControllerAdvice
public class HandlerException {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    protected ModelAndView exceptionHandler(HttpServletRequest request, Exception e) throws Exception {
        logger.error("Request URL: {}, Exception: {}", request.getRequestURL(), e);
        if (null!=AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class)) {
            throw e;
        }
        ModelAndView view = new ModelAndView();
        view.addObject("URL", request.getRequestURL());
        view.addObject("Exception", e);
        view.setViewName("error/error");
        return view;
    }
}
