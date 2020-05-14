package com.linhua.study.bean;

import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


/**
 * AnnotationAwareAspectJAutoProxyCreator
 *
 */

/**
 * @author linhua
 * @apiNote
 * @date 2020-04-21 2:31 下午
 */
@Component
public class Car implements InitializingBean, DisposableBean {

    private int color;

    public Car(int color){
        this.color = color;
    }


    public Car(){
        System.out.println("car constructor........\n");
    }


    /**
      AnnotationAwareAspectJAutoProxyCreator
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {

        System.out.println("初始化car bean........\n");
    }

    @PostConstruct
    private void init(){
        System.out.println("init 在bean初始化之前");
    }

    @PreDestroy
    private void preDestroy(){
        System.out.println("preDestroy 销毁car bean之前.......\n");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("销毁car bean.......\n");
    }
}
