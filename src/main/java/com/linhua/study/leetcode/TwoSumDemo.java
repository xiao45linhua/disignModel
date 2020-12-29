package com.linhua.study.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSumDemo {

    /**
     * leetcode
     * @param nums 输入数组
     * @param target 目标数
     * @return 输出
     */
    static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int low = 0;
        int high = nums.length -1;
        while(low < high){
            if (nums[low] + nums[high] == target){
                result[0] = low;
                result[1] = high;
                break;
            }else{
                if (nums[low] + nums[high] > target) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        return result;
    }

    /**
     * 三数和
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int k = 0; k < nums.length - 2; k++){
            if(nums[k] > 0) break;
            if(k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = nums.length - 1;
            while(i < j){
                int sum = nums[k] + nums[i] + nums[j];
                if(sum < 0){
                    while(i < j && nums[i] == nums[++i]);
                } else if (sum > 0) {
                    while(i < j && nums[j] == nums[--j]);
                } else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        int target = 30;
        int[] result = twoSum(nums,target);
        System.out.print("【"+result[0]+"+"+result[1]+"】");

    }
}
