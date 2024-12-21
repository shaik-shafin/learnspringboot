package com.shaik.acknowledge.aop;

import com.shaik.acknowledge.aop.annotation.MyCustomAnnotation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class LoggingAspect {

    /**
     * ------------------------------------------------------------
     * 1.EXECUTION : TRY TO MATCH A PARTICULAR METHOD IN A PARTICULAR CLASS
     * ------------------------------------------------------------
     **/

    @Before("execution(public String com.shaik.acknowledge.aop.MainClass.showMessage())")
    public void beforeMethod1(){
        System.out.println("Method-1 run before actual method");
    }

    //it matches any method but must have 0 parameter
    @Before("execution(* com.shaik.acknowledge.aop.MainClass.*())")
    public void beforeMethod2(){
        System.out.println("Method-2 run before actual method");
    }

    //it matches any method but must have 1 parameter as string
    @Before("execution(* com.shaik.acknowledge.aop.MainClass.*(String))")
    public void beforeMethod3(){
        System.out.println("Method-3 run before actual method");
    }

    //it matches 1 or more parameters
    @Before("execution(* com.shaik.acknowledge.aop.MainClass.*(*))")
    public void beforeMethod4(){
        System.out.println("Method-4 run before actual method");
    }

    //it matches 0 or more parameters
    @Before("execution(* com.shaik.acknowledge.aop.MainClass.*(..))")
    public void beforeMethod5(){
        System.out.println("Method-5 run before actual method");
    }

    //it matches any package and subpackages
    @Before("execution(* com.shaik.acknowledge..*(String))")
    public void beforeMethod6(){
        System.out.println("Method-6 run before actual method");
    }

    //it matches any package and subpackages and 0 or more params
    @Before("execution(* com.shaik..*(..))")
    public void beforeMethod7(){
        System.out.println("Method-7 run before actual method");
    }

    /**
     * ------------------------------------------------------------
     * 2.WITHIN : MATCHES ALL METHODS WITHIN ANY CLASS OR ANY METHOD
     * ------------------------------------------------------------
     **/

    @Before("within(com.shaik.acknowledge.aop.MainClass)")
    public void beforeMethod8(){
        System.out.println("Method-8 run before actual method");
    }

    @Before("within(com.shaik.acknowledge.aop.*)")
    public void beforeMethod9(){
        System.out.println("Method-9 run before actual method");
    }

    /**
     * ------------------------------------------------------------
     * 3.@WITHIN : MATCHES ALL METHODS WITHIN ANY CLASS OR ANY METHOD WHICH HAS THIS ANNOTATION
     * ------------------------------------------------------------
     **/

    @Before("@within(org.springframework.stereotype.Service)")
    public void beforeMethod10(){
        System.out.println("Method-10 run before actual method");
    }

    /**
     * ------------------------------------------------------------
     * 4.@ANNOTATION : MATCHES ANY METHOD THAT HAS THIS ANNOTATION
     * ------------------------------------------------------------
     **/

    @Before("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void beforeMethod11(){
        System.out.println("Method-11 run before actual method");
    }

    /**
     * ------------------------------------------------------------
     * 5.ARG : MATCHES ANY METHOD WITH PARTICULAR ARGUMENT
     * ------------------------------------------------------------
     **/

    @Before("args(String, int)")
    public void beforeMethod12(){
        System.out.println("Method-12 run before actual method");
    }

    /**
     * ------------------------------------------------------------
     * 6.@ARG : MATCHES ANY METHOD WITH PARTICULAR ARGUMENT WHICH HAS THIS ANNOTATION
     * ------------------------------------------------------------
     **/

    /*@Before("@args(org.springframework.stereotype.Component)")
    public void beforeMethod13(){
        System.out.println("Method-13 run before actual method");
    }*/

    /**
     * ------------------------------------------------------------
     * 6.TARGET : MATCHES ANY METHOD ON PARTICULAR INSTANCE OF CLASS
     * ------------------------------------------------------------
     **/

    //By class
    @Before("target(com.shaik.acknowledge.aop.AopService)")
    public void beforeMethod14(){
        System.out.println("Method-14 run before actual method");
    }

    //By interface
    @Before("target(com.shaik.acknowledge.aop.IEmployee)")
    public void beforeMethod15(){
        System.out.println("Method-15 run before actual method");
    }

    /**
     * ------------------------------------------------------------
     * COMBINATION
     * ------------------------------------------------------------
     **/

    @Before("execution(* com.shaik.acknowledge.aop.MainClass.*()) && @within(org.springframework.web.bind.annotation.RestController)")
    public void beforeMethod16(){
        System.out.println("Method-16 run before actual method");
    }

    /**
     * ------------------------------------------------------------
     * NAMED POINTCUT
     * ------------------------------------------------------------
     **/

    @Pointcut("execution(* com.shaik.acknowledge.aop.MainClass.*()) && @within(org.springframework.web.bind.annotation.RestController)")
    public void beforeMethod17(){}

    @Before("beforeMethod17()")
    public void beforeMethod18(){
        System.out.println("Method-18 run before actual method");
    }

    /**
     * ------------------------------------------------------------
     * @AFTER : SAME LIKE @BEFORE IT WILL EXECUTE AFTER THE METHOD
     * ------------------------------------------------------------
     **/

    @After("beforeMethod17()")
    public void beforeMethod19(){
        System.out.println("Method-19 run after actual method");
    }

    /**
     * ------------------------------------------------------------
     * @AROUND : IT WILL BE FOR USE BOTH @BEFORE AND @AFTER
     * ------------------------------------------------------------
     **/

    @Around("beforeMethod17()")
    public void beforeMethod20(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("Method-20 run before actual method");
        proceedingJoinPoint.proceed();
        System.out.println("Method-20 run after actual method");
    }

    @Around("@annotation(com.shaik.acknowledge.aop.annotation.MyCustomAnnotation)")
    public void beforeMethod21(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{


        System.out.println("*********** do something before MyCustomAnnotation ************");

        Method method = ((MethodSignature) proceedingJoinPoint.getSignature()).getMethod();
        if(method.isAnnotationPresent(MyCustomAnnotation.class)){
            MyCustomAnnotation myCustomAnnotation = method.getAnnotation(MyCustomAnnotation.class);
            System.out.println(myCustomAnnotation.key());
        }
        proceedingJoinPoint.proceed();
        System.out.println("*********** do something after MyCustomAnnotation ************");
    }

}
