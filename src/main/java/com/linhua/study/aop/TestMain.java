package com.linhua.study.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author linhua
 * @apiNote
 * @date 2020-05-14 4:43 下午
 */

public class TestMain {
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext ApplicationContext2 = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
        /**
         * 不要自己创建对象，使用spring 中的对象
         */
//        MathCalculator mathCalculator = new MathCalculator();
//        mathCalculator.div(2,3);

        MathCalculator objectBean = ApplicationContext2.getBean(MathCalculator.class);
        objectBean.div(2,3);
        ApplicationContext2.close();

    }

}
