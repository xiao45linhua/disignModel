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

    //求两个数相加目标值为k的两个数下标 1,2,3三个数，目标为4，则第一次存入进去的是kv为3-1
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
    private int[] twosum(int[] nums,int target){
        int result[] = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;i++){
            if (map.containsKey(nums[i])){
                result[0] = 0;
                result[1] = map.get(nums[i]);
                return result;
            }
            map.put(target-nums[i],i);
        }
        return result;
    }
    //最长不重复子序列长度
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

    //最长回文子串
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

    /**
     * 快排
     */
    public static void quickSort(int[] num,int left, int right){
        if (right - left <= 1){
            return;
        }
        //设置最左边的元素为基准值
        int key=num[left];
        //数组中比key小的放在左边，比key大的放在右边，key值下标为i
        int i=left;
        int j=right;
        while (i < j) {
            while (num[j] > key && i < j) {
                j--;
            }
            while (num[i] < key && i < j) {
                i++;
            }
            //i和j指向的元素交换
            if (i < j) {
                int temp = num[i];
                num[i] = num[j];
                num[j] = temp;
            }
        }
        num[left]=num[i];
        num[i]=key;
        quickSort(num,left,i-1);
        quickSort(num,i+1,right);

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
                    nums[p + 1] = nums[q]; }
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
//反转链表
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
     * 容器成最多水含量 ,前后两个指针去遍历，小的组移动
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

    //盛最多水
    public static long maxWater (int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int low = 0;
        long sum = 0;
        long tmp = 0;
        //从左向右
        for (int i = 0; i < arr.length; i++) {
            //遇到小于它的数就用temp存起来可以临时存放水的空间，直到遇到了大于或者等于它的数就把这个临时空间实现真正存水
            if (arr[low] > arr[i]) {
                tmp = tmp + arr[low] - arr[i];
            }
            if (arr[low] <= arr[i]) {
                sum = sum + tmp;
                tmp = 0;
                low = i;
            }
        }
        low = arr.length-1;
        tmp = 0;
        //从右向左
        for (int j = arr.length-1; j >= 0; j--) {
            if (arr[low] > arr[j]) {
                tmp = tmp + arr[low] - arr[j];
            }
            //注意这里不能再 <=，否则可能会重复计算等于的情况
            if (arr[low] < arr[j]) {
                sum = sum + tmp;
                tmp = 0;
                low = j;
            }
        }
        return sum;
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
        //先找到相遇点，之后把快节点放在头，一块走，相遇的位置就是入口点
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

    //快速排序思想+二分查找寻找第k大元素
    public int findKth(int[] a, int n, int K) {
        // write code here
        return findK(a, 0, n-1, K);
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];

        while (left < right) {
            while (left < right && arr[right] <= pivot) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] >= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }
    public static int findK(int[] arr, int left, int right, int k) {
        if (left <= right) {
            int pivot = partition(arr, left, right);

            if (pivot == k - 1) {
                return arr[pivot];
            } else if (pivot < k - 1) {
                return findK(arr, pivot + 1, right, k);
            } else {
                return findK(arr, left, pivot - 1, k);
            }
        }
        return -1;
    }


    //给定一个数组arr，返回子数组的最大累加和
    public int maxsumofSubarray (int[] arr) {
        // write code here
        if(arr.length == 0)
            return 0;
        int sum = arr[0];
        int max = sum;
        for(int i = 1;i < arr.length;i++){
            sum = sum > 0 ? sum + arr[i] : arr[i];
            max = Math.max(max,sum);
        }
        return max;
    }

// 最小k个数
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || input.length == 0 || k > input.length || k == 0)
            return list;
        int[] arr = new int[k + 1];//数组下标0的位置作为哨兵，不存储数据
        //初始化数组
        for (int i = 1; i < k + 1; i++)
            arr[i] = input[i - 1];
        buildMaxHeap(arr, k + 1);//构造大根堆
        for (int i = k; i < input.length; i++) {
            if (input[i] < arr[1]) {
                arr[1] = input[i];
                adjustDown(arr, 1, k + 1);//将改变了根节点的二叉树继续调整为大根堆
            }
        }
        for (int i = 1; i < arr.length; i++) {
            list.add(arr[i]);
        }
        return list;
    }
    /**
     * @Author: ZwZ
     * @Description: 构造大根堆
     * @Param: [arr, length]  length:数组长度 作为是否跳出循环的条件
     * @return: void
     * @Date: 2020/1/30-22:06
     */
    public void buildMaxHeap(int[] arr, int length) {
        if (arr == null || arr.length == 0 || arr.length == 1)
            return;
        for (int i = (length - 1) / 2; i > 0; i--) {
            adjustDown(arr, i, arr.length);
        }
    }
    /**
     * @Author: ZwZ
     * @Description: 堆排序中对一个子二叉树进行堆排序
     * @Param: [arr, k, length]
     * @return:
     * @Date: 2020/1/30-21:55
     */
    public void adjustDown(int[] arr, int k, int length) {
        arr[0] = arr[k];//哨兵
        for (int i = 2 * k; i <= length; i *= 2) {
            if (i < length - 1 && arr[i] < arr[i + 1])
                i++;//取k较大的子结点的下标
            if (i > length - 1 || arr[0] >= arr[i])
                break;
            else {
                arr[k] = arr[i];
                k = i; //向下筛选
            }
        }
        arr[k] = arr[0];
    }
}
//给定一个整数数组，找出两个下标，要求后面下标所指的数减去前面下标所指的数之差最大
    public static int[] fun(int a[]){
        int b[]=new int[2];
        if(a==null || a.length<2){
            b[0]=0;
            b[1]=0;
            return b;
        }
        b[0]=0;
        int cha=b[1]-b[0];
        int temp = a[0];
        for(int i=1;i<a.length;i++){
            if(a[i]<a[temp])
                temp = i;
            if((a[i]-a[temp])>cha){
                b[1]=i;
                b[0] = temp;
                cha=a[i]-a[b[0]];
            }
        }
        return b;
    }

    //z遍历
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder (TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root!=null){
            queue.add(root);
        }
        while(!queue.isEmpty()){
            ArrayList<Integer> tmp = new ArrayList<>();     //存储每一层节点
            for(int i= queue.size();i>0;i--){               //遍历当前层的节点
                TreeNode node = queue.poll();               //弹出队列中的节点
                if((res.size()+1)%2!=0){     //res.size()+1：当前的层数，从1开始
                    tmp.add(node.val);       // 奇数层 -> 尾插
                }else{
                    tmp.add(0,node.val);     // 偶数层 -> 头插
                }
                if(node.left!=null){         //如果左子节点不为空，则将其加入到队列中
                    queue.add(node.left);
                }
                if(node.right!=null){         //如果左子节点不为空，则将其加入到队列中
                    queue.add(node.right);
                }
            }
            res.add(tmp);               //将这一层的节点加入到res中
        }
        return res;
    }
    //最长公共子序列
    public String LCS (String str1, String str2) {
        // write code here
        if (str1 == null || str2 == null) return "-1";
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        if (m == 0 || n == 0) return "-1";
        int maxLen = 0, x = 0;
        for (int i = 0; i < m; i++) {
            char c1 = str1.charAt(i);
            for (int j = 0; j < n; j++) {
                // 获取两个串字符
                char c2 = str2.charAt(j);
                if (c1 == c2) {
                    // 去找它们前面各退一格的值加1即可
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    if (dp[i + 1][j + 1] > maxLen) {
                        maxLen = dp[i + 1][j + 1];
                        x = i + 1;
                    }
                }
            }
        }
        return maxLen == 0 ? "-1" : str1.substring(x - maxLen, x);
    }

    //公共祖先 ，其实就是递归查找自节点的过程，在递归退出时候，返回公共祖先
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        return CommonAncestor(root, o1, o2).val;
    }
    public TreeNode CommonAncestor (TreeNode root, int o1, int o2) {
        if (root == null || root.val == o1 || root.val == o2) { // 超过叶子节点，或者root为p、q中的一个直接返回
            return root;
        }
        TreeNode left = CommonAncestor(root.left,o1,o2); // 返回左侧的p\q节点 其实就是递归查找节点值的过程
        TreeNode right = CommonAncestor(root.right,o1,o2); // 返回右侧的p\q节点
        if (left == null) {  // 都在右侧
            return right;
        }
        if (right == null) { // 都在左侧
            return left;
        }
        return root; // 在左右两侧
    }
    //两个链表公共节点
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null)return null;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while(p1!=p2){
            p1 = p1.next;
            p2 = p2.next;
            //但是，a+b == b+a 因此，可以让a+b作为链表A的新长度，b+a作为链表B的新长度。
            if(p1 != p2){
                if(p1 == null)p1 = pHead2;
                if(p2 == null)p2 = pHead1;
            }
        }
        return p1;
    }

    /**
     *
     题号	题解
     121. 买卖股票的最佳时机	暴力解法、动态规划（Java）
     122. 买卖股票的最佳时机 II	暴力搜索、贪心算法、动态规划（Java）
     123. 买卖股票的最佳时机 III	动态规划（Java）
     188. 买卖股票的最佳时机 IV	动态规划（「力扣」更新过用例，只有优化空间的版本可以 AC）
     309. 最佳买卖股票时机含冷冻期	动态规划（Java）
     714. 买卖股票的最佳时机含手续费	动态规划（Java）
     * @param args
     */

    /**
     * 一次股票买卖机会
     * @param
     */
    public static int getMaxProfit(int[] prices){
        int len = prices.length;
        if (len < 2){
            return 0;
        }
        int[] f = new int[2];
        f[0] = 0;  //表示当前未持有股票
        f[1] = -prices[0];  //表示当前未持有股票 初始值为已经买了
        for (int i =1; i< len;i++){
            f[0] = Math.max(f[0],prices[i] + f[1]);
            f[1] = Math.max(f[1],-prices[i]);
        }
        return f[0];
    }

    /**
     *  1.确定最终状态 2.确定初始值 3:状态方程
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int dp0 = 0;                    // 一直不买
        int dp1 = - prices[0];          // 只买了一次
        int dp2 = Integer.MIN_VALUE;    // 买了一次，卖了一次

        for(int i = 1; i < prices.length; i++){
            dp1 = Math.max(dp1, dp0 - prices[i]);
            dp2 = Math.max(dp2, dp1 + prices[i]);
        }
        return Math.max(dp0, dp2);
    }


    /**
     * 多次股票买卖机会,必须买-卖-买
     * @param
     */
    public static int getMaxProfit2(int[] prices){
        int len = prices.length;
        if (len < 2){
            return 0;
        }
        int[] f = new int[2];
        f[0] = 0;  //表示未持有股票状态
        int preCash = 0; //之前的现金
        f[1] = -prices[0];  //表示当前未持有股票 初始值为已经买了
        int preHold = f[1];
        for (int i =1; i< len;i++){
            f[0] = Math.max(preCash,prices[i] + preHold);
            f[1] = Math.max(preHold,preCash - prices[i]);
            preCash =  f[0];
            preHold = f[1];
        }
        return f[0];
    }

    /**
     * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     *
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        if(prices.length < 2) return 0;

        int dp0 = 0;                 // 一直不买
        int dp1 = - prices[0];       // 到最后也只买入了一笔
        int dp2 = Integer.MIN_VALUE; // 到最后买入一笔，卖出一笔
        int dp3 = Integer.MIN_VALUE; // 到最后买入两笔，卖出一笔
        int dp4 = Integer.MIN_VALUE; // 到最后买入两笔，卖出两笔

        for(int i = 1; i < prices.length; i++){
            dp1 = Math.max(dp1, dp0 - prices[i]);
            dp2 = Math.max(dp2, dp1 + prices[i]);
            dp3 = Math.max(dp3, dp2 - prices[i]);
            dp4 = Math.max(dp4, dp3 + prices[i]);
        }
        return Math.max(dp2, dp4);
    }

//NC38螺旋矩阵Java题解
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
    ArrayList<Integer> res = new ArrayList<>();
    //matrix.length==0判断如果是一维矩阵，那么matrix[0]就会报错。
    if(matrix.length==0) return res;
    int col = matrix[0].length-1;
    int row = matrix.length-1;
    //起始点是col/2和row/2的最小值
    for(int i=0;i<=Math.min(col/2,row/2);i++){
        ArrayList<Integer> list = getList(i,matrix,col,row);
        res.addAll(list);
    }
    return res;
}
    //从某个点开始的螺旋结果
    public static ArrayList<Integer> getList(int i, int[][] matrix,int col,int row) {
        //（i,i） (i,col-i)   (row-i,col-i)  (row-i,i)
        ArrayList<Integer> list =new ArrayList<>();
        //对于特殊情况的判断 只有一个点
        if(row-i==i && col-i==i){
            list.add(matrix[i][i]);
            return list;
        }
        for (int c=i;c<=col-i;c++){
            list.add(matrix[i][c]);
        }
        for (int r=i+1;r<=row-i;r++){
            list.add(matrix[r][col-i]);
        }
        //此时只有一行
        if(row-i!=i){//去重
            for(int c=col-i-1;c>=i;c--){
                list.add(matrix[row-i][c]);
            }
        }
        //此时只有一列
        if(col-i!=i) {//去重
            for (int r = row - i-1; r > i; r--) {
                list.add(matrix[r][i]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int a[] = {3,1,2,6,0,4,7};
        String b = "accdabcd";
        System.out.println(lengthOfLongestSubstring(b));
//
//        System.out.println(maxWater(a));
//
//        System.out.println("xiaolinhua".hashCode());
    }

}
