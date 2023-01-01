package com.learn.spring.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

// All Aspect classes should have @Configuration to indicate the class
// contains the AOP configuration
// AOP terminology is present here
// https://www.udemy.com/course/spring-boot-and-spring-framework-tutorial-for-beginners/learn/lecture/35088148#notes
@Configuration
@Aspect
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    // Pointcut defines which methods should be intercepted
    @Before("com.learn.spring.aop.aspects.CommonPointcutConfig.allPackageConfigUsingBean()")
    public void logMethodCallBeforeExecution(JoinPoint joinPoint) {
        logger.info("Before Aspect - Method called - {}", joinPoint);
    }

    @After("com.learn.spring.aop.aspects.CommonPointcutConfig.businessAndDataPackageConfig()")
    // Executes even if an exception is thrown
    public void logMethodCallAfterExecution(JoinPoint joinPoint) {
        logger.info("After Aspect - Method called - {}", joinPoint);
    }

    @AfterThrowing(pointcut = "com.learn.spring.aop.aspects.CommonPointcutConfig.businessAndDataPackageConfig()", throwing = "exception")
    public void logMethodCallAfterThrowing(JoinPoint joinPoint, Exception exception) {
        logger.info("AfterThrowing Aspect - Method called - {}, Exception - {}", joinPoint, exception);
    }

    // Only after successful execution
    @AfterReturning(pointcut = "com.learn.spring.aop.aspects.CommonPointcutConfig.businessAndDataPackageConfig()", returning = "result")
    public void logMethodCallAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("AfterReturning Aspect - Method called - {}, Result - {}", joinPoint, result);
    }
}
