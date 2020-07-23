package com.linhua.study.designModel.proxy.dynamicproxy.jdkproxy;

import com.linhua.study.designModel.proxy.Person;

/**
 * @author linhua
 * @version 1.0
 * @Description:
 * @date 2020/7/23$ 8:18 下午$
 */
public class Man implements Person {
    @Override
    public void findLove() {
        System.out.println("开始选美女");
        System.out.println("168cm");
    }
}
