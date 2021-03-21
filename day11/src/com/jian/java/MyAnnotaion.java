package com.jian.java;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Jiange
 * @create 2021-03-19-12:25
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.TYPE_PARAMETER})
public @interface MyAnnotaion {
    String jian() default "jian";
}
