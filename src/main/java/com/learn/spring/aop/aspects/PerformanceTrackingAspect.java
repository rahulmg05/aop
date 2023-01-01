package com.learn.spring.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class PerformanceTrackingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    // @Around("com.learn.spring.aop.aspects.CommonPointcutConfig.dataPackageConfig()")
    @Around("com.learn.spring.aop.aspects.CommonPointcutConfig.trackTimeAnnotation()")
    public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // Start a timer
        long startTimeMillis = System.currentTimeMillis();
        // Execute a method
        Object result = proceedingJoinPoint.proceed();

        logger.info("Execution time - {}", System.currentTimeMillis() - startTimeMillis);

        return result;
    }
}
