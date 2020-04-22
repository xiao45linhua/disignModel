package com.linhua.study.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author linhua
 * @apiNote
 * @date 2020-04-11 2:56 下午
 */

public class MacCondition implements Condition {
    /**
     *
     * @param conditionContext  当前容器上下文
     * @param annotatedTypeMetadata 当前注释
     * @return true
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //获取ioc使用的容器工厂
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        //获取到类加载器
        ClassLoader classLoader = conditionContext.getClassLoader();
        //获取到当前运行环境
        Environment environment = conditionContext.getEnvironment();
        return false;
    }
}
