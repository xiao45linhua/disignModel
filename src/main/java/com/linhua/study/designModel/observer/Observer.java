package com.linhua.study.designModel.observer;

/**
 * 观察者 就是动作行为的被动者
 */
public interface Observer {

    /**
     * 更新回调
     * @param message
     */
    void update(String message);
}
