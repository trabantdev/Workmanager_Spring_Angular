package com.tobiastrabant.workmanager.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(public void save(com.tobiastrabant.workmanager.entities.Employee))")
    public void beforeSaveEmployeeAdvice() {
        System.out.println("Save employee is being called");
    }
}
