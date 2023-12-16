package com.sukri.users.management.logging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogMethodAspect {
    @Before("execution(* com.sukri.users.management..*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        Object[] args = joinPoint.getArgs();
        log.info("Enter ==> method: {}::{}, arguments: {}", className, methodName, args);
    }

    @AfterReturning(pointcut = "execution(* com.sukri.users.management..*(..))", returning = "result")
    public void logMethodExit(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        log.info("Exit <== method: {}::{}, result: {}", className, methodName, result);
    }
}
