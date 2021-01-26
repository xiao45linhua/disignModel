package com.linhua.study.spring;

/**
 * @author linhua
 * @date 2021/1/13
 * @description
 */

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
//import org.springframework.stereotype.Component;

//@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    public MyBeanPostProcessor() {
        super();
        System.out.println("这是BeanPostProcessor实现类构造器！！"); //3
        // TODO Auto-generated constructor stub
    }

    @Override
    public Object postProcessBeforeInitialization(Object arg0, String arg1)
            throws BeansException {
        System.out
                .println("bean实例话之后，BeanPostProcessor接口方法postProcessBeforeInitialization对属性进行更改！");   //12
        return arg0;
    }

    @Override
    public Object postProcessAfterInitialization(Object arg0, String arg1)
            throws BeansException {
        System.out
                .println("bean实例话之前，BeanPostProcessor接口方法postProcessAfterInitialization对属性进行更改！");  //15
        return arg0;
    }


}