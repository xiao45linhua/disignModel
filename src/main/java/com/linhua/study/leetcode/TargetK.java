package com.linhua.study.leetcode;

import java.util.*;

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

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public LinkNode getNext() {
            return next;
        }

        public void setNext(LinkNode next) {
            this.next = next;
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


    public String longestPalindrome(String s) {
        // 特判
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        // dp[i][j] 表示 s[i, j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        //大于3的话，就要取前面的值
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }


    public static void quickSort(int[] num,int left, int right){
        if (right - left <= 1){
            return;
        }
        //设置最左边的元素为基准值
        int key=num[left];
        //数组中比key小的放在左边，比key大的放在右边，key值下标为i
        int i=left;
        int j=right;
        while (i < j){
            while(num[j] > key && i<j ){
                j--;
            }
            while (num[i] < key && i <j){
                i++;
            }
            //i和j指向的元素交换
            if(i<j){
                int temp=num[i];
                num[i]=num[j];
                num[j]=temp;
            }
            num[left]=num[i];
            num[i]=key;
            quickSort(num,left,i-1);
            quickSort(num,i+1,right);
        }

    }

    /**
     * 爬台阶
     * @param n
     */
    public static int climbStairs(int n){
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    //三数之和为0
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if(nums == null || len < 3) return ans;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len ; i++) {
            if(nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
            int L = i+1;
            int R = len-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]) L++; // 去重
                    while (L<R && nums[R] == nums[R-1]) R--; // 去重
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return ans;
    }

    /**
     * 移除重复元素
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int p = 0;
        int q = 1;
        while(q < nums.length){
            if(nums[p] != nums[q]){
                if(q - p > 1){
                    nums[p + 1] = nums[q];
                }
                p++;
            }
            q++;
        }
        return p + 1;
    }

    /**
     * 二分查找算法
     * @param nums 数组
     * @param target 目标值
     * @return
     */
    int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // 注意

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1; // 注意
            else if (nums[mid] > target)
                right = mid - 1; // 注意
        }
        return -1;
    }

    public LinkNode reverserLinkedList3(LinkNode node){
        //指向空，可以想象成位于第一个节点之前
        LinkNode newNode = null;
        //指向第一个节点
        LinkNode curNode = node;

        //循环中，使用第三变量事先保存curNode的后面一个节点

        while (curNode != null){
            LinkNode tempNode = curNode.next;
            //把curNode反向往前指
            curNode.setNext(newNode);
            //newNode向后移动
            newNode = curNode;
            //curNode 向后移动
            curNode = tempNode;
        }

        return newNode;
    }

    /**
     * 容器成最多水含量
     * @param height
     * @return
     */
    public static int maxArea(int[] height){
        int l = 0, r = height.length - 1;
        int ans = 0;
        //l和r分别表示双指针的左右指针
        while (l < r){
            int area = Math.min(height[l],height[r])*(r -l);
            ans = Math.max(area,ans);
            if (height[l] <= height[r]){
                l ++;
            }
            else {
                r --;
            }
        }
        return ans;
    }

    //全排列
    public static List<List<Integer>> permute(int[] nums) {
        // 首先是特判
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();

        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private static void dfs(int[] nums, int len, int depth,
                     List<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
            // 3、不用拷贝，因为每一层传递下来的 path 变量都是新建的
            res.add(path);
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                // 1、每一次尝试都创建新的变量表示当前的"状态"
                List<Integer> newPath = new ArrayList<>(path);
                newPath.add(nums[i]);

                boolean[] newUsed = new boolean[len];
                System.arraycopy(used, 0, newUsed, 0, len);
                newUsed[i] = true;

                dfs(nums, len, depth + 1, newPath, newUsed, res);
                // 2、无需回溯
            }
        }
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    //重建二叉树
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length == 0 || in.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        for(int i = 0;i < in.length;i++){
            if(in[i] == pre[0]){
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                break;
            }
        }
        return root;
    }

    /**
     * 前序遍历* 递归
     */
    public void preOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    //非递归
    public void preOrder1(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        while(node != null || !stack.empty()) {
            while (node != null){
                System.out.println(node.val);
                stack.push(node);
                node = node.left;
            }
            if(!stack.empty()){
                node = stack.pop();
                node = node.right;
            }
        }
    }

    /**
     * 中序遍历* 递归
     */
    public void midOrder(TreeNode node) {
        if (node != null) {
            midOrder(node.left);
            System.out.print(node.val + " ");
            midOrder(node.right);
        }
    }

    //中序Morris遍历算法，主要是通过增加右子节点的右节点指向当前节点的父节点。
    //判断cur节点是否为空
    //如果不为空
    //    1）如果cur没有左孩子，cur向右更新，即（cur = cur.right）
    //    2）如果cur有左孩子，则从左子树找到最右侧节点pre
    //   如果pre的右孩子为空，则将右孩子指向cur。 pre.right = cur
    //   如果pre的右孩子为cur，则将其指向为空。pre.right = null。（还原树结构）
    //   cur为空时，停止遍历
    public void morris_midOrder(TreeNode node){
        //设置当前节点做遍历用
        TreeNode cur = node;
        while(cur != null){
            //如果当前节点没有左节点，则直接输出，cur指向右节点
            if (cur.left == null){
                System.out.println(cur.val);
                cur = cur.right;
            } else {
                TreeNode pre = cur.left;
                while (pre.right != null || pre.right != cur){
                    pre = pre.right;  //走左子树的最右端
                }
                if(pre.right == null){	// 第一次到达左子树的最右端
                    pre.right = cur;
                    //System.out.print(cur.val);  //前序放这
                    cur = cur.left;
                }else{ // 第二次到达左子树的最右端 恢复树结构
                    pre.right = null;
                    System.out.print(cur.val);      //中序遍历和前序差不多，主要是打印输出的位置不一样，
                    cur = cur.right;
                }
            }
        }
    }
    /**
     * 后序遍历 * 递归
     */
    public void posOrder(TreeNode node) {
        if (node != null) {
            posOrder(node.left);
            posOrder(node.right);
            System.out.print(node.val + " ");
        }
    }
    //非递归算法空间复杂度为o(n)

    public void levelOrder(TreeNode node) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>(20);
        //首先将根节点加入栈中
        queue.add(node);
        //遍历二叉树
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            System.out.print(tempNode.val + " ");

            if(tempNode.left != null){
                queue.add(tempNode.left);
            }
            if(tempNode.right != null){
                queue.add(tempNode.right);
            }
        }
    }

     class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
      }
    //获取环的入口节点
    public ListNode detectCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        while(true){
            if(fast == null || fast.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("abcdabdd"));

        System.out.println("xiaolinhua".hashCode());
    }

}
