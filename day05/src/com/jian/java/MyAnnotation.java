package com.jian.java;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * @author Jiange
 * @create 2021-03-12-16:58
 *  声明为@interface
 */
//@Documented
//@Retention(RetentionPolicy.RUNTIME)
//@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, MODULE,TYPE_PARAMETER,TYPE_USE})
//@Inherited
////@Repeatable()
//
//public @interface MyAnnotation {
//    String[] value() default "jiange";
//    int age();
//}
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE_PARAMETER,TYPE})
@Inherited
public @interface MyAnnotation{
    String value();
}
