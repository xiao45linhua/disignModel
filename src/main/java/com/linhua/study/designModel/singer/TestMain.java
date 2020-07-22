package com.linhua.study.designModel.singer;

import java.io.*;
import java.lang.reflect.Constructor;

/**
 * @author linhua
 * @version 1.0
 * @Description:
 * @date 2020/7/13$ 10:26 上午$
 */
//单例模式
public class TestMain {
    public static void main(String[] args) {

        //破坏单利模式，利用反射
        try {
            Class<?> clazz = LazySingleton.class;
            Constructor c = clazz.getDeclaredConstructor(null);
            c.setAccessible(true);
            Object o1 = c.newInstance();

            Object o2 = LazySingleton.getInstance();

            System.out.println(o1 == o2);
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("objectFile"));
            HungrySingleton singleton1 = HungrySingleton.getInstance();
            os.writeObject(singleton1);
            os.close();

            ObjectInputStream is = new ObjectInputStream(new FileInputStream(new File("objectFile")));
            HungrySingleton singleton2 = (HungrySingleton) is.readObject();
            is.close();

            System.out.println(singleton1 == singleton2);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
