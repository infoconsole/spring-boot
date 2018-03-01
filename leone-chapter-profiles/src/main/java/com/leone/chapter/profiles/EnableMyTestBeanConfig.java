package com.leone.chapter.profiles;


import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(MyTestBeanRegistrar.class)
public @interface EnableMyTestBeanConfig {

	String[] value() default {};


	int order() default Ordered.LOWEST_PRECEDENCE;
}
