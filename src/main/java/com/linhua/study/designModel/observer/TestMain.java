package com.linhua.study.designModel.observer;

/**
 * @author linhua
 * @apiNote 观察着测试类
 * @date 2020-04-22 3:30 下午
 */

public class TestMain {

    public static void main(String[] args) {
        Observer a = new ObserverImpl("zhangsan");
        Observer b = new ObserverImpl("lisi");
        Observer c = new ObserverImpl("wangwu");
        WeixinObserver observerable = new WeixinObserver();
        //a像管理者注册
        observerable.registerObserver(a);
        observerable.registerObserver(b);
        observerable.registerObserver(c);
        observerable.setInfomation("测试观察者模式");
        System.out.println("----------------------------------------------");
        observerable.removeObserver(a);
        observerable.setInfomation("取消观察者张三！");

    }
}
