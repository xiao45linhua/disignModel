package com.linhua.study.hash;

/**
 * @author linhua
 * @date 2021/2/2
 * @description 使用fnvi_32Hash
 */
public class GetHashCode {

    private static final long FNV_32_INIT = 2166136261L;
    private static final int FNV_32_PRIME = 16777619;

    public int getHashCode(String object){
        final int p = FNV_32_PRIME;
        int hash = (int)FNV_32_INIT;
        for (int i = 0; i < object.length(); i++) {
            hash = (hash ^ object.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        hash = Math.abs(hash);

        return hash;
    }
}
