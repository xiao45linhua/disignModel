package com.linhua.study.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author linhua
 * @apiNote
 * @date 2020-05-08 11:29 下午
 */

public class TargetK {

    public static class LinkNode{
        int val;
        LinkNode next;
        public LinkNode(int val) {
            this.val = val;
        }
    }

    /**
     * 相等链表相加
     * @param l1
     * @param l2
     * @return
     */
    public LinkNode addTowLink(LinkNode l1,LinkNode l2){
        if (l1 == null && l2 == null){
            return null;
        }
        LinkNode dumNode = new LinkNode(0);
        LinkNode head = dumNode;
        int addOne = 0;
        while (l1 != null || l2 != null || addOne !=0){
            int val1 = l1 ==null? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2+addOne;
            head.next = new LinkNode(sum%10);
            head = head.next;
            addOne = sum/10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return dumNode.next;
    }

    //求两个数相加目标值为k的两个数下标

    public int[] twoSum(int[] nums, int target) {
        int[] indexs = new int[2];
        Map<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(hash.containsKey(nums[i])){
                indexs[0] = i;
                indexs[1] = hash.get(nums[i]);
                return indexs;
            }
            //i为存进去的下标，key为要补的数
            hash.put(target-nums[i],i);
        }
        return indexs;
    }

    public static int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }


    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("abcdabdd"));
    }
}
