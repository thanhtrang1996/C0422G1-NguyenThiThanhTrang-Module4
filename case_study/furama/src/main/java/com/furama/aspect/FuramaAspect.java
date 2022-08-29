package com.furama.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FuramaAspect {
    private int count = 0;
    @AfterReturning(pointcut = "execution(* com.furama.controller.CustomerController.*(..))")
    public void infoProcessing(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        int c = count++;
        System.err.println(" Method " + methodName + " finished running " + c + " times");
    }
}
