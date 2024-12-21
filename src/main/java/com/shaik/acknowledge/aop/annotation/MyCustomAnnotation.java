package com.shaik.acknowledge.aop.annotation;

import com.shaik.acknowledge.aop.myenum.TrueFalse;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyCustomAnnotation {

    int key() default 0;

    String stringKey() default "defaultString";

    Class<?> classTypeKey() default String.class;

    TrueFalse enumKey() default TrueFalse.FALSE;

    String[] stringArrKey() default {"defaultString1", "defaultString2"};

    int[] intArrKey() default {1, 2};

}
