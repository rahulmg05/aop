package com.learn.spring.aop.aspects;

import org.aspectj.lang.annotation.Pointcut;

// This class basically names the point cuts. Instead of adding the entire method
// references as point cuts, we can add the point cut names. This way if the method
// moves to a different package or the existing package name changes, all we have to
// do is just make changes to the package names here against doing it for every method.
public class CommonPointcutConfig {
    @Pointcut("execution(* com.learn.spring.aop.*.*.*(..))")
    public void businessAndDataPackageConfig() {}

    @Pointcut("execution(* com.learn.spring.aop.business.*.*(..))")
    public void businessPackageConfig() {}

    @Pointcut("execution(* com.learn.spring.aop.data.*.*(..))")
    public void dataPackageConfig() {}

    // Intercept all bean method calls based on their names. For eg: if the bean names
    // have something like "Service" intercept them
    @Pointcut("bean(*dataService*)")
    public void allPackageConfigUsingBean() {}

    // Intercept only on methods where the annotation is defined (In this case
    // where the TrackTime annotation is defined)
    @Pointcut("@annotation(com.learn.spring.aop.annotations.TrackTime)")
    public void trackTimeAnnotation() {}
}
