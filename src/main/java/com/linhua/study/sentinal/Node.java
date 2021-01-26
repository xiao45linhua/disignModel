package com.linhua.study.sentinal;

/**
 * @author linhua
 * @date 2021/1/11
 * @description
 */
public class Node {

    private long time;

    private long counter;

    private int id;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getCounter() {
        return counter;
    }

    public void setCounter(long counter) {
        this.counter = counter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Node(long time, long counter, int id) {
        this.time = time;
        this.counter = counter;
        this.id = id;
    }
}
