package com.linhua.study.leetcode;

/**
 * @author linhua
 * @apiNote
 * @date 2020-02-21 4:00 下午
 */

public class MedianSortedArrays {
    public static double findMedianSortedArrays(int[] num1,int[] num2){
        int n = num1.length;
        int m = num2.length;

        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(num1, 0, n - 1, num2, 0, m - 1, left) + getKth(num1, 0, n - 1, num2, 0, m - 1, right)) * 0.5;

    }
    private static int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];
        //最后肯定执行这个
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }

    public static void main(String[] args){
        String s = "1234565432";
        long n = Long.parseLong(s);

        System.out.print(n);

        }

}
