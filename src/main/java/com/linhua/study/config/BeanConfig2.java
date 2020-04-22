package com.linhua.study.config;

import com.linhua.study.bean.Person;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * @author linhua
 * @apiNote
 * @date 2020-04-10 8:08 下午
 */

@Configurable
public class BeanConfig2 {
//    @Scope(value = "prototype")
//    @Lazy
    @Bean("personBean")
    public Person person(){
        System.out.println("bean创建");
        return new Person("linhua",13);
    }
}
