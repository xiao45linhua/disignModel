package com.linhua.study.designModel.observer;

/**
 * @author linhua
 * @apiNote 被动观察者的实现类
 * @date 2020-04-22 2:22 下午
 */

public class ObserverImpl implements Observer {


    private String name;

    private String message;

    public ObserverImpl(String name){
        this.name = name;
    }

    @Override
    public void update(String message) {
        this.message = message;
        read();
    }

    private void read() {
        System.out.println(name + " 收到推送消息： " + message);
    }
}
