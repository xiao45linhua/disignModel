package com.linhua.study.socket;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author linhua
 * @apiNote
 * @date 2020-04-24 1:54 下午
 */

public class NioFileChannel {

    public static void main(String[] args) throws Exception{

        String str = "hello,world";
        //创建一个输入流
        FileOutputStream fileOutputStream = new FileOutputStream("file.txt");
        //通过这个输出流获取对应的channel
        //FileChannel的真实类型是
        FileChannel channel = fileOutputStream.getChannel();
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        allocate.put(str.getBytes());
        //反转
        allocate.flip();
//        channel.read(allocate);
        channel.write(allocate);
        fileOutputStream.close();


        FileInputStream inputStream = new FileInputStream("file.txt");
        FileChannel channel1 = inputStream.getChannel();
        allocate.clear();
        //把通道里面的数据读入到allocate
        channel1.read(allocate);
        System.out.println(new String(allocate.array()));


    }
}
