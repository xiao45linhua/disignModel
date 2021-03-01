package com.linhua.study.leetcode;

import java.util.ArrayList;
import java.util.List;
import com.linhua.study.leetcode.TargetK.ListNode;
import com.linhua.study.leetcode.TargetK.TreeNode;

/**
 * @author linhua
 * @date 2021/3/1
 * @description
 */
public class Solution {

    //岛屿问题思路： dfs 深度优先
    //遍历整块大陆，横着竖着遍历都可以。
    //第一次碰到陆地的时候，就知道这是块岛屿了，所以将这块陆地放入探险队列，岛屿数量加一。
    //然后我们将这块岛屿的陆地探索完。每一次将这块陆地周围（上下左右）的陆地放入队列，然后将这块陆地标记为已探索（这里就直接置为'0'了）。
    //当探险队列为空时，表示这块岛屿的陆地全部被探索完了，我们继续寻找下一块陆地。
    public int solve (char[][] grid) {
        if (grid == null || grid.length == 0) {return 0;}
        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1' ) {
                    num_islands++;
                    dfs(grid, r, c);
                }}}
        return num_islands;
    }
    public void dfs(char[][] grid,int r,int c){ //r为行
        int nr = grid.length;
        int nc = grid[0].length;
        if(r <0 || c <0 || r> nr-1 || c > nc-1 || grid[r][c] == '0'){
            return;
        }
        grid[r][c] = '0'; //遍历过的点置 0
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
    //最长递增子序列

    /**
     * 初始情况下，result为[2]，maxLen[1]
     * 接下来遇到3，由于vec最后一个元素小于3，直接更新，vec为[2,3]，maxLen[1,2]
     * 接下来遇到1，由于vec最后的元素大于1, 我们在vec中查找大于等于1的第一个元素的下标，并用1替换之，此时vec为[1,3], maxLen[1,2,1]
     * 接下来遇到2，由于vec最后的元素大于2，我们在vec中查找大于等于2的第一个元素的下标，并用2替换之，此时vec为[1,2], maxLen[1,2,1,2]
     * 接下来遇到3，由于vec最后一个元素小于3，直接更新，vec为[1,2,3]，maxLen为[1,2,1,2,3]
     * 此时vec的大小就是整个序列中最长递增子序列的长度（但是vec不一定是本题的最终解）
     */
    public int[] LIS (int[] arr) {
        // write code here
        List<Integer> result = new ArrayList<>();
        int[] maxLength = new int[arr.length]; //maxLen数组里存放以元素i结尾的最大递增子序列长度，
        for (int i = 0 ; i<arr.length;i++ ){
            if (result.size() > 0){
                if (result.get(result.size()-1) < arr[i]){
                    result.add(arr[i]);
                    maxLength[i] = result.size();
                }else{
                    for (int j = result.size() - 1 ; j >= 0 ; j--){
                        if (result.get(j) < arr[i]){
                            result.set(j+1,arr[i]);
                            maxLength[i] = j + 2;
                            break;
                        }
                        if (j == 0){
                            result.set(0,arr[i]);
                            maxLength[i] = 1;
                        }
                    }
                }
            }else {
                result.add(arr[i]);
                maxLength[i] = 1;
            }
        }
        //对于第二步，假设我们原始数组是arr1，得到的maxLen为[1,2,3,1,3]，
        //最终输出结果为res（字典序最小的最长递增子序列），res的最后一个元素在arr1中位置无庸置疑是maxLen[i]==3对应的下标，
        //那么到底是arr1[2]还是arr1[4]呢？如果是arr1[2]，那么arr1[2]<arr1[4]，则maxLen[4]==4，与已知条件相悖。
        //因此我们应该取arr1[4]放在res的最后一个位置。利用倒序赋值
        int[] resultArray = new int[result.size()];
        for (int i = arr.length -1 , j = result.size(); j > 0; i-- ){
            if (maxLength[i] == j){
                resultArray[--j] = arr[i];
            }
        }
        return resultArray;
    }
    //矩阵最小的路径和
    public int minPathSum (int[][] matrix) {
        int[][]  dp = new int[matrix.length][matrix[0].length];
        dp[0][0] = matrix[0][0];
        for(int i =1; i< matrix.length; i++) { //走两边
            dp[i][0] =  dp[i-1][0] + matrix[i][0];
        }
        for(int i =1; i< matrix[0].length; i++) {
            dp[0][i] =  dp[0][i-1] + matrix[0][i];
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[matrix.length-1][matrix[0].length-1];
    }
    //链表归并排序
    public ListNode sortInList (ListNode head) {
        // write code here
        if(head == null || head.next == null)
            return head;
        //使用快慢指针找到中点
        TargetK.ListNode slow = head, fast = head.next;
        while(fast!=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //分割为两个链表
        TargetK.ListNode newList = slow.next;
        slow.next = null;
        //将两个链表继续分割
        ListNode left = sortInList(head);
        ListNode right = sortInList(newList);

        ListNode lhead = new ListNode(-1);
        ListNode res = lhead;
        //归并排序
        while(left != null && right != null){
            if(left.val < right.val){
                lhead.next = left;
                left = left.next;
            }else{
                lhead.next = right;
                right = right.next;
            }
            lhead = lhead.next;
        }
        lhead.next = left!=null?left:right; //判断左右链表是否为空
        return res.next;
    }

    //判断是否是回文字符串：快慢指针 得到最终点，把后面得反转之后在两个对比就行

    //二叉树镜像
    public TreeNode Mirror (TreeNode pRoot) {
        // write code here
        if(pRoot == null) return pRoot;
        TreeNode temp= pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = temp;
        Mirror(pRoot.left);
        Mirror(pRoot.right);
        return pRoot;
    }
}
