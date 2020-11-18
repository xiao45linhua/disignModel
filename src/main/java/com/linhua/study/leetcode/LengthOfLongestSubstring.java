package com.linhua.study.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @apiNote
 * @author bjhl
 */
public class LengthOfLongestSubstring {

    public static String getLongestSubstring(String str){
        if (str == null || "".equals(str)){
            return "";
        }
        int length = str.length();
        //key 为字符，value 为下标
        Map<Character,Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        for(start = 0,end = 0; end < length;end ++){
            char tmp = str.charAt(end);
            if (map.containsKey(tmp)){
                start = Math.max(map.get(tmp),start);
            }
        }
        return null;
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            //找到了一个重复的，就把开始的位置和重复的位置做对比，然后就重新定位开始的位置，因为重复了，所以之前的可以直接放弃掉，重新开始弄长度
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            //记录是第几个数，方便直接放弃掉之前的数
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }

    public static void main(String[] args){
        int result = lengthOfLongestSubstring("abcacde");
        int i = 1;
        switch (i){
            case 1: System.out.print("1");
            break;
            case 2: System.out.print("2");
            default:

        }
        System.out.print(result+"\n");
    }
}
