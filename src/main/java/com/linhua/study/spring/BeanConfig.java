package com.linhua.study.spring;

import com.linhua.study.spring.MyBeanFactoryPostProcessor;
import com.linhua.study.spring.MyBeanPostProcessor;
import com.linhua.study.spring.MyInstantiationAwareBeanPostProcessor;
import com.linhua.study.spring.Person;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


/**
 * @author linhua
 * @apiNote
 * @date 2020-04-10 7:31 下午
 */

@Configurable
//@ComponentScan(basePackages = {"com.linhua.study.spring"})
public class BeanConfig {

    @Bean
    public MyBeanPostProcessor myBeanPostProcessor(){
        return new MyBeanPostProcessor();
    }

    @Bean
    public MyBeanFactoryPostProcessor myBeanFactoryPostProcessor(){
        return new MyBeanFactoryPostProcessor();
    }


    @Bean
    public MyInstantiationAwareBeanPostProcessor myInstantiationAwareBeanPostProcessor(){
        return new MyInstantiationAwareBeanPostProcessor();
    }

    @Bean
    public Person person(){
        try {
            Class<?> clazz =  Class.forName("com.linhua.study.spring.Person");
            System.out.println("clazz 加载");
            return (Person)clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
       // return new Person();
    }


    //@bean里面有initMethod和destoryMethod方法，可以用来去bean之前和
    //如果是多实例的化就要手动销毁方法，因为spring 不会帮你去管理bean
//    @Scope
//    @Bean("personBean")
//    public Person person(){
//        return new Person("linhua",13);
//    }

//    @Bean
//    // @PostConstruct 作用在方法上，在bean创建完成并且，属性值赋值完成
//    // @PreDestroy bean在销毁之前做的
//    public Car car(){
//        return new Car(2);
//    }
}
