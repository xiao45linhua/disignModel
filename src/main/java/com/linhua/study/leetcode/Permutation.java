package com.linhua.study.leetcode;

/**
 * @author linhua
 * @date 2021/2/21
 * @description
 */
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Permutation {
    public static ArrayList<String> lists=new ArrayList<>();
    public static ArrayList<String> Permutation(String str) {
        if(str.length()==0||str==null){
            return lists;
        }
        permute(str.toCharArray(),0);
        return lists;
    }
    private  static void permute(char[] nums, int index) {
        //边界值判断
        if(index==nums.length){
            if(!lists.contains(String.valueOf(nums))){
                lists.add(String.valueOf(nums));  //第一次到这里的时候
            }
            return;
        }
        for(int i = index;i<nums.length;i++){
            swap(nums,index,i);
            permute(nums,index+1);
            swap(nums,index,i);

        }
    }

    private static void swap(char[] nums, int index, int i) {
        char t =nums[index];
        nums[index] = nums[i];
        nums[i] = t;
    }

    public static void main(String[] args){

        String str = "aab";
        lists=Permutation(str);

        System.out.println(new Gson().toJson(lists));
    }
}