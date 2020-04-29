package com.linhua.study.socket;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author linhua
 * @apiNote
 * @date 2020-04-27 8:04 下午
 */

public class NioSelectServer {

    public static void main(String[] args) throws Exception {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.socket().bind(new InetSocketAddress(9000));
        //设置阻塞非阻塞
        serverSocketChannel.configureBlocking(false);

        Selector selector = Selector.open();

        // configureBlocking 如果不设置非阻塞，register的时候会报异常
        // java.nio.channels.IllegalBlockingModeException
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {

            int selected = selector.select();

            if (selected > 0) {

                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {

                    SelectionKey selectionKey = iterator.next();
                    iterator.remove();

                    if (selectionKey.isAcceptable()) {
                        System.err.println("Acceptable");
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ);
                    } else if (selectionKey.isReadable()) {
                        System.err.println("Readable");
                        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(128);
                        socketChannel.read(buffer);
                        System.out.println("接收来自客户端的数据：" + new String(buffer.array()));
                        selectionKey.interestOps(SelectionKey.OP_WRITE);
                    } else if (selectionKey.isWritable()) {
                        System.err.println("Writable");
                        SocketChannel channel = (SocketChannel) selectionKey.channel();
                        String content = "向客户端发送数据 : " + System.currentTimeMillis();
                        ByteBuffer buffer = ByteBuffer.wrap(content.getBytes());
                        channel.write(buffer);
                        selectionKey.interestOps(SelectionKey.OP_READ);
                    }
                }
            }
        }
    }
}
