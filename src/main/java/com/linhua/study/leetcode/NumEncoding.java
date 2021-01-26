package com.linhua.study.leetcode;

/**
 * @author linhua
 * @date 2021/1/6
 * @description 动态规范的实现
 */
public class NumEncoding {
    public static int getNumEncoding(String ss){
        char[] s = ss.toCharArray();
        if (s.length == 0){
            return 0;
        }
        int n = s.length;
        int[] f = new int[n+1];
        f[0] = 1;
        for (int i = 1; i <= n; i++){
            f[i] = 0 ;
            //last digest
            int t = s[i-1] -'0';
            if (t >= 1 && t <=9 ){
                f[i] = f[i-1];
            }
            if (i >= 2){
                t = s[i-2]*10 + s[i -1];
                if (t <= 26 && t >= 10){
                    f[i] += f[i-2];
                }
            }
        }
        return f[n];
    }
}
