package com.linhua.study.sentinal;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @author linhua
 * @date 2021/1/11
 * @description
 */

public class SlidingWindowCounterLimit extends CounterLimiter {

    private static Logger logger = LoggerFactory.getLogger(SlidingWindowCounterLimit.class);

    /** 格子分布 */
    private Node[] gridDistribution;
    /** 当前时间在计数分布的索引 */
    private volatile int currentIndex;
    /** 当前时间之前的滑动窗口计数 */
    private int preTotalCount;
    /** 要分割多少块 */
    private int gridNumber;
    /** 是否正在执行状态重置 */
    private volatile boolean resetting;
    //每个格子代表的时间段
    private long slotTime;

    public SlidingWindowCounterLimit(int gridNumber, int limitCount, long limitTime) {
        this(gridNumber, limitCount, limitTime, TimeUnit.SECONDS);
    }

    public SlidingWindowCounterLimit(int gridNumber, int limitCount, long limitTime, TimeUnit timeUnit) {
        if (gridNumber <= limitTime)
            throw new RuntimeException("无法完成限流，gridNumber必须大于limitTime，gridNumber = " + gridNumber + ",limitTime = " + limitTime);
        this.gridNumber = gridNumber;
        this.limitCount = limitCount;
        this.limitTime = limitTime;
        this.timeUnit = timeUnit;
        long current = System.currentTimeMillis();
        gridDistribution = new Node[gridNumber];
        //初始化
        for (int i = 0; i < gridNumber; i++) {
            gridDistribution[i] = new Node(current,0,i+1);
        }
        //总共限制的时间除以总共格子数
        slotTime = timeUnit.toMillis(limitTime)/gridNumber;

    }


    @Override
    public synchronized boolean tryCount() {
        //先确定窗口位置
        return false;
    }

    public static int[] findDiagonalOrder(int[][] matrix) {
        int n = matrix.length;
        if(n == 0){
            return null;
        }
        int m = matrix[0].length;
        int[] res = new int[m*n];
        int ids = 0;
        for(int i = 0;i < n+m-1;i++){
            if(i%2 == 0){
                //从下网上
                for(int j = i/m; j <= i;j++){
                    res[ids++] = matrix[i-j][j];
                }
            } else {
                //从上往下
                for(int j = i/n; j <= i;j++){
                    res[ids++] = matrix[j][i-j];
                }
            }

        }
        return res;
    }

    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if(n == 0){
            return "";
        }
        int num = strs[0].length();
        //第一个字符串遍历
        int i;
        for(i = 0;i<num;i++){
            char a = strs[0].charAt(i);
            for(int j = 1;j < n; j++){
                char b = strs[j].charAt(i);
                if(a != b){
                    break;
                }
            }
        }
        if(i > 0){
            return strs[0].substring(0,i);
        }
        return "";
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(findDiagonalOrder(nums));

    }
}
