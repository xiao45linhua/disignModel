package com.linhua.study.sentinal;

import java.util.concurrent.TimeUnit;

/**
 * @author linhua
 * @date 2021/1/11
 * @description
 */
public abstract class CounterLimiter {
    /** 单位时间限制数 */ //10s 50次
    protected int limitCount;
    /** 限制时间 */ //几秒钟
    protected long limitTime;
    /** 时间单位，默认为秒 */
    protected TimeUnit timeUnit;

    /** 当前是否为受限状态 */
    protected volatile boolean limited;

    /**
     * 尝试将计数器加1，返回为true表示能够正常访问接口，false表示访问受限
     * @return
     */
    protected abstract boolean tryCount();
}
