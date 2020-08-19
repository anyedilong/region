package com.region.until.validate;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Documented
@Component
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD,ElementType.PARAMETER})
public  @interface Validate {

	/**
	 * 检验命名 支持通配符
	 */
	String[] name() default {};
    /**
     * 是否必填
     * @return
     */
    boolean required() default  false;

    /**
     * 是否是数字
     * @return
     */
    boolean number() default  false;

    /**
	 * 校验类型
	 */
	ValidateType[] type() default {ValidateType.GENERAL};
	
	/**
	 *长度 
	 */
	int length() default 0;
	
	/**
	 * 最大长度
	 */
	int maxLength() default 0;
	
	/**
	 * 最小长度
	 */
	int minLength() default 0;
	
	/**
	 * 检验字段
	 */
	String fieldName() default "";
}
