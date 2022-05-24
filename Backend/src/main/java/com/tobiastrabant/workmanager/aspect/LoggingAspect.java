package com.tobiastrabant.workmanager.aspect;

import com.tobiastrabant.workmanager.entities.Employee;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private static Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Before("execution(* save(com.tobiastrabant.workmanager.entities.Employee))")
    public void beforeSaveEmployeeAdvice(JoinPoint joinPoint) {

        logger.info("Save employee is being called");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        logger.info("from @Before: The method signature is: " + methodSignature);

        Object[] passedArgs = joinPoint.getArgs();

        for(Object arg : passedArgs) {
            logger.info(arg.toString());

            if(arg instanceof Employee) {
                Employee employee = (Employee) arg;

                logger.info("employee firstName: " + employee.getFirstName());
                logger.info("employee lastName: " + employee.getLastName());
                logger.info("employee email: " + employee.getEmail());
            }
        }
    }

    @AfterReturning(pointcut = "execution(* save(com.tobiastrabant.workmanager.entities.Employee))",
                    returning = "savedEmployee")
    public void afterReturningSaveEmployeeAdvice(JoinPoint joinPoint, Employee savedEmployee) {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        logger.info("from @AfterReturning: The method signature is " + methodSignature);
        logger.info("from @AfterReturning: The saved employee is " + savedEmployee);
        //testing modification of returning result:
        savedEmployee.setFirstName(savedEmployee.getFirstName().toUpperCase());
        logger.info("from @AfterReturning: The saved employees first name is " + savedEmployee.getFirstName());
    }

    @AfterThrowing(pointcut = "execution(* save(com.tobiastrabant.workmanager.entities.Employee))",
                    throwing = "exception")
    public void afterThrowingSaveEmployeeAdvice(JoinPoint joinPoint, Throwable exception) {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        logger.info("from @AfterThrowing: The method signature is " + methodSignature);

        logger.info("from @AfterThrowing: The exception is " + exception);
    }

    @After("execution(* save(com.tobiastrabant.workmanager.entities.Employee))")
    public void afterSaveEmployeeAdvice(JoinPoint joinPoint) {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        logger.info("from @After: The method signature is " + methodSignature);
    }
}
