package com.linhua.study;

import com.linhua.study.bean.Cat;
import com.linhua.study.spring.BeanConfig;
import com.linhua.study.spring.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @author linhua
 * @apiNote
 * @date 2020-04-10 7:29 下午
 */

public class MainTest {

    public synchronized void demo1(){
        System.out.println("hello");
        demo2();
    }

    public synchronized void demo2(){ //增加重入次数
        System.out.println("hello2");
    }

    public static void main(String[] args) {

//        ApplicationContext applicationContext  = new AnnotationConfigApplicationContext(BeanConfig.class);
//        System.out.println("ioc容器加载");
//        System.out.println(applicationContext.getId());
//        Object bean = applicationContext.getBean("person");
//        System.out.println("Person初始化完成");
//
//        Environment environment = applicationContext.getEnvironment();
//        String property = environment.getProperty("os.name");
//        System.out.println(property);

        MainTest n = new MainTest();
        n.demo1();

        Cat cat = new Cat() {
            @Override
            public void run() {
                super.run();
                System.out.println("111111111111111111111");
            }
        };
        cat.run();
        //说明两个bean是一样的实例
//        System.out.println(Arrays.toString(applicationContext.getBeanNamesForType(Person.class)));

        Map mpa = new ConcurrentHashMap<>();
        HashMap map = new HashMap();

    }
}
