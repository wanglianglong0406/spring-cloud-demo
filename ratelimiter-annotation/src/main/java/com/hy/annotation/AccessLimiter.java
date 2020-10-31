package com.hy.annotation;

import java.lang.annotation.*;

/**
 * @author 寒夜
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AccessLimiter {

    int limit();

    String methodKey() default "";

}
