package com.linhua.study.designModel.singer;

/**
 * @author linhua
 * @version 1.0
 * @Description:
 * @date 2020/7/13$ 10:39 上午$
 */
public class LazySingleton {
    private static LazySingleton lazySingleton = null;

    //构造方法私有化了，但是通不过反射的法眼
    //初始化过一次就不能构建了

    private LazySingleton(){
        if (InnerSingleton.LAZY != null){
            throw new RuntimeException("不允许构建");
        }
    }

    //在类上的锁，
//    public synchronized static LazySingleton getInstance(){
//        if (null == lazySingleton){
//            lazySingleton = new LazySingleton();
//        }
//        return lazySingleton;
//    }

    //利用到内部类的加载解决
    //完美的避免了线程安全问题
    public static final LazySingleton getInstance(){
        return InnerSingleton.LAZY;
    }


    private static class InnerSingleton{
        private static final LazySingleton LAZY = new LazySingleton();
    }

}
