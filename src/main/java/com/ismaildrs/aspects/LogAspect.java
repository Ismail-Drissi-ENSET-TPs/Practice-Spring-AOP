package com.ismaildrs.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
@EnableAspectJAutoProxy
public class LogAspect {
    Logger logger = Logger.getLogger(LogAspect.class.getName());

    @Around("@annotation(com.ismaildrs.aspects.Log)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("******");
        Object value = joinPoint.proceed();
        logger.info("******");
        return value;
    }

}
