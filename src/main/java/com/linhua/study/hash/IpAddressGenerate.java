package com.linhua.study.hash;

import java.util.Random;

/**
 * @author linhua
 * @date 2021/2/2
 * @description
 */
public class IpAddressGenerate {
    public String[] getIpAddress(int num){
        String[] res = new String[num];
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            res[i] = String.valueOf(random.nextInt(256)) + "." + String.valueOf(random.nextInt(256)) + "."
                    + String.valueOf(random.nextInt(256)) + "." + String.valueOf(random.nextInt(256)) + ":"
                    + String.valueOf(random.nextInt(9999));
        }
        return res;
    }
}
