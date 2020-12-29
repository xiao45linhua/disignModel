package com.linhua.study.buffer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author linhua
 * @date 2020/12/7
 * @description
 */
public class MappedByteBufferTest {
    public static void main(String[] args) throws IOException {
//        int length = 0x8FFFFFF;
//        FileChannel channel = FileChannel.open(Paths.get("store/test"), StandardOpenOption.READ,StandardOpenOption.WRITE);
//        MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE,0,length);

        List<String> names = new ArrayList<>();
        names.add("王鹏伟");
        names.add("陈荣升");
        names.add("赵少敏");
        names.add("皇甫家昕");
        names.add("李军博");
        names.add("王宁(wangning12)");
        names.add("姜勇");
        names.add("薛玮栋");
        names.add("刘艳艳(liuyanyan03)");
        names.add("卜婉颖");
        names.add("肖林华");
        names.add("秦浩然");
        names.add("王跃(wangyue28)");
        names.add("陈立(chenli06)");
        names.add("李强(liqiang04)");
        names.add("赵可(zhaoke01)");
        names.add("李淑峰");
        names.add("张博芳");
        names.add("王学良");
        Collections.shuffle(names);
        for (String i : names){
            System.out.println(i);
        }


    }
}
