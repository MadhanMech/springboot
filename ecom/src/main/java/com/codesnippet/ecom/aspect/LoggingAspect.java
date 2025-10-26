package com.codesnippet.ecom.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    @Pointcut("execution(* com.codesnippet.ecom.Service.*.*(..))") 
    private void anyOldTransfer() {}

    @Around("anyOldTransfer()")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Aspect log called");
        //method/jointpoint 
        Object result = joinPoint.proceed();
        System.out.println("Aspect after log calleddf");
        return result;
    }
}
