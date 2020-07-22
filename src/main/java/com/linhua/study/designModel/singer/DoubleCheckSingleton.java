package com.linhua.study.designModel.singer;

/**
 * @author linhua
 * @version 1.0
 * @Description: 双重检查单利模式
 * @date 2020/7/13$ 11:32 上午$
 */
public class DoubleCheckSingleton {

    private static volatile DoubleCheckSingleton Singleton = null;

    private DoubleCheckSingleton(){}

    //双重检查机制
    public static DoubleCheckSingleton getInstance(){
        if (null == Singleton){
            synchronized (DoubleCheckSingleton.class) {
                if (Singleton == null) {
                    Singleton = new DoubleCheckSingleton();
                }
            }
        }
        return Singleton;
    }
}


