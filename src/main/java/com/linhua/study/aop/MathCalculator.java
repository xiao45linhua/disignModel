package com.linhua.study.aop;

/**
 * @author linhua
 * @apiNote
 * @date 2020-05-14 4:27 下午
 */
public class MathCalculator {

    //定义一个div除法
    public int div(int i,int j){
        System.out.println("MathCalculator...div...");
        return i/j;
    }
}
