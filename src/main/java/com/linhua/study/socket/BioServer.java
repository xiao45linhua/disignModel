package com.linhua.study.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author linhua
 * @apiNote
 * @date 2020-04-23 11:32 上午
 */

public class BioServer {

    public static void main(String[] args) throws Exception{
        //socket监听端口6666
        ServerSocket serverSocket = new ServerSocket(6666);

        ExecutorService executor = Executors.newCachedThreadPool();

        while (true){
            final Socket socket = serverSocket.accept();
            System.out.println("服务器启动了。。。。。\n");
            executor.execute(() -> {
                //在这里面去处理客户端通信内容
                handler(socket);
            });

        }

    }

    public static void handler(Socket socket){
        try {
            byte[] bytes = new byte[1024];
            InputStream inputStream = socket.getInputStream();
            //循环的读取客户端发送的数据
            while (true){
                int read = inputStream.read(bytes);
                if (read == -1){
                    break;
                }else {
                    System.out.println(new String(bytes,0,read));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("关闭socket链接");
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("关闭链接报错");
                e.printStackTrace();
            }
        }

    }
}
