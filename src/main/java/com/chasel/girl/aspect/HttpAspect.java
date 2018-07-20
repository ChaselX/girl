package com.chasel.girl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author XieLongzhen
 * @date 2018/7/14 17:43
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    // getList(..) 代表只要是这个方面，里面的任何参数都会被拦截
    @Pointcut("execution(public * com.chasel.girl.controller.GirlController.*(..))")
    public void exec() {
    }

    @Before("exec()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
//        url
        logger.info("url={}", request.getRequestURL());
//        method
        logger.info("method={}", request.getMethod());
//        ip
        logger.info("ip={}", request.getRemoteAddr());
//        类方法
        logger.info("class_name={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//        参数
        logger.info("args={}", joinPoint.getArgs());
//        logger.info("before");
    }

    @After("exec()")
    public void doAfter() {
//        logger.info("after");
    }

    @AfterReturning(pointcut = "exec()",returning = "object")
    public void doAfterReturning(Object object) {
        logger.info("response={}",object);
    }
}
