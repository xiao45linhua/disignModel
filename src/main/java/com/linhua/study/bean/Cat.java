package com.linhua.study.bean;

import org.apache.dubbo.common.URL;

/**
 * @author linhua
 * @apiNote
 * @date 2020-04-21 3:24 下午
 */

public abstract class Cat  implements Animal{

    @Override
    public void run() {
        System.out.println("正常猫这样跑");
    }



}
