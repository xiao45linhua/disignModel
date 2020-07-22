package com.linhua.study.designModel.singer;


import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @author linhua
 * @version 1.0
 * @Description:
 * @date 2020/7/13$ 10:28 上午$
 */
//饿汉单例模式
public class HungrySingleton implements Serializable {
    //缺点：不管你用不用都要初始化，浪费内存空间
   // private static final HungrySingleton hungry = new HungrySingleton();
    //在类加载的时候实例化
    private static final HungrySingleton hungry;

    static {
        hungry = new HungrySingleton();
    }
    private HungrySingleton(){}

    public static HungrySingleton getInstance(){
        return hungry;
    }

    /** 单例对象实现了Serializable接口，通过重写readResolve()禁止程序通过深拷贝创建多个实例，达到破坏单例对象的目的 */
    //还是创建了两次对象，知识这个readResolve出来的对象覆盖了原来反序列化的对象，发生在jvm层面，相对来说比较安全，
    private Object readResolve() throws ObjectStreamException {

        return hungry;
    }

}
