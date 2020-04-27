package com.linhua.study.socket;

import java.nio.IntBuffer;

/**
 * @author linhua
 * @apiNote
 * @date 2020-04-23 1:32 下午
 */

public class NioServer {
    public static void main(String[] args) {

        IntBuffer buffer = IntBuffer.allocate(5);

        for (int i =0;i<5;i++){
            buffer.put(i*2);
        }
        buffer.flip();
    }
}
