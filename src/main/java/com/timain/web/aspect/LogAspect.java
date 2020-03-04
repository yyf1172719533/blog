package com.timain.web.aspect;

import com.timain.web.result.RequestObj;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/3/3 22:01
 */
@Aspect
@Component
public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(* com.timain.web.controller.*.*(..))")
    public void log() {

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        RequestObj obj = new RequestObj(url, ip, classMethod, args);
        logger.info("Result:" + obj);
    }

    @After("log()")
    public void doAfter() {}

    @AfterReturning(returning = "result", pointcut = "log()")
    public void afterReturn(Object result) {
        logger.info("result:" + result);
    }
}
