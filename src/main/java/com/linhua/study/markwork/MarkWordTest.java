package com.linhua.study.markwork;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author linhua
 * @date 2020/11/18
 * @description
 */
public class MarkWordTest {
/**
    图中的1、2、3、4分别对应 MarkWord、类型指针、实例数据、对齐填充。

    MarkWord：共8字节，该对象刚新建，还处于无锁状态，所以锁标识位是 01
    类型指针：共4字节，标识新建的 person 属于哪个类
    实例数据：共8字节，定义的 Person 有两个属性，str 和 son，他们对应的类型分别为 String 和 Son，这两个属性每个占4个字节
    对齐填充：共4个字节，前三个部分所占大小相加 8+ 4+ 8 = 20，不是8的整数倍，所以得填充4个字节凑齐24字节。描述信息中也有说明： loss due to the next object aligment
*/

    private byte str;
    private int i;
    public static void main(String[] args) throws InterruptedException {

//        Thread.sleep(5000);
//        Object person = new Object();
////        System.out.println("hash: " + person.hashCode());
//        System.out.println(ClassLayout.parseInstance(person).toPrintable());
//        synchronized (person) {
//            System.out.println(ClassLayout.parseInstance(person).toPrintable());
//        }
        Thread.sleep(5000);
        Object o = new Object();
        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }

        for (int i = 0; i < 1; i++) {
            Thread t = new Thread(() -> {
                print(o);
            });
            t.start();
        }

    }
    public static void print(Object o) {
        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }

}
