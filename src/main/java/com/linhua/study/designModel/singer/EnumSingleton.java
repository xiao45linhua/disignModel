package com.linhua.study.designModel.singer;



/**
 * @author linhua
 * @version 1.0
 * @Description:
 * @date 2020/7/14$ 10:33 上午$
 */
public enum  EnumSingleton {
    INSTANCE;

    private Object data;

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }
}
