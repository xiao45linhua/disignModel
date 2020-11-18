package com.linhua.study.leetcode;

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

    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        int target = 30;
        int[] result = twoSum(nums,target);
        System.out.print("【"+result[0]+"+"+result[1]+"】");

    }
}
