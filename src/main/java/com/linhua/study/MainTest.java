package com.linhua.study;

import com.linhua.study.bean.Car;
import com.linhua.study.bean.Person;
import com.linhua.study.config.BeanConfig;
import com.linhua.study.config.BeanConfig2;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Arrays;


/**
 * @author linhua
 * @apiNote
 * @date 2020-04-10 7:29 下午
 */

public class MainTest {

    @Autowired
    private Car car;


    public static void main(String[] args) {

        ApplicationContext applicationContext  = new AnnotationConfigApplicationContext(BeanConfig.class);
//        ApplicationContext applicationContext  = new AnnotationConfigApplicationContext(BeanConfig.class);
//        System.out.println(applicationContext.getId());
//        Object bean = applicationContext.getBean("personBean");
//        Object bean2 = applicationContext.getBean("car");
//        AnnotationConfigApplicationContext ApplicationContext2 = new AnnotationConfigApplicationContext(BeanConfig.class);
//        System.out.println(bean == bean2);
        System.out.println("ioc容器加载");

        Environment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);



        //说明两个bean是一样的实例
        System.out.println(Arrays.toString(applicationContext.getBeanNamesForType(Person.class)));
//        String[] Type = applicationContext.getBeanNamesForType(Person.class);
//        System.out.println();


    }
}
