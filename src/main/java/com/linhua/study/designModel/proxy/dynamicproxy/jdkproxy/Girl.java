package com.linhua.study.designModel.proxy.dynamicproxy.jdkproxy;

import com.linhua.study.designModel.proxy.Person;

/**
 * @author linhua
 * @version 1.0
 * @Description:
 * @date 2020/7/23$ 5:21 下午$
 */
public class Girl implements Person {
    @Override
    public void findLove() {
        System.out.println("高富帅");
        System.out.println("身高180cm");
        System.out.println("有6块腹肌");
    }
}
