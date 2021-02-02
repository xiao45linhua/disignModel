package com.linhua.study.bean;

import org.apache.dubbo.common.URL;

/**
 * @author linhua
 * @date 2021/1/27
 * @description
 */
public class WhileCat extends Cat {

    @Override
    public void run() {
        super.run();
    }


    public void doRegister(URL url) {
        System.out.println("mobanfangfa");
    }
}
