package com.ismaildrs.aspects;

import com.ismaildrs.service.SecurityContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class AuthzAspect {
    @Around(value = "@annotation(securedByAspect)", argNames = "joinPoint,securedByAspect")
    public Object around(ProceedingJoinPoint joinPoint, SecuredByAspect securedByAspect) throws Throwable {
        boolean authorized= false;
        for(String role : securedByAspect.roles()){
            if(SecurityContext.hasRole(role)){
                authorized=true;
                break;
            }
        }
        if(authorized){
            Object result = joinPoint.proceed();
            return result;
        } else {
            throw new RuntimeException("You're not authorized");
        }
    }
}
