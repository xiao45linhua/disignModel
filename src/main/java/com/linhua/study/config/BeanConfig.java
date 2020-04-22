package com.linhua.study.config;

import com.linhua.study.bean.Car;
import com.linhua.study.bean.Person;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author linhua
 * @apiNote
 * @date 2020-04-10 7:31 下午
 */

@Configurable
@ComponentScan(basePackages = {"com.linhua.study.bean"})
public class BeanConfig {

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
