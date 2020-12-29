package com.linhua.study.leetcode;


public class SumTwoNumberDemo {
    //假如是按大小顺序放入链表，也一样可以参考这个思路
    public static Node sumTwoNumber(Node na,Node nb) {
        Node head = new Node(0);
        Node curr = head;
        Node a1 = na;
        Node b1 = nb;
        int carry = 0;
        while (a1 != null || b1 != null) {
            int x = (a1 != null) ? a1.getValue() : 0;
            int y = (b1 != null) ? b1.getValue() : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.setNext(new Node(sum % 10));
            curr = curr.getNext();
            if (a1 != null) a1 = a1.getNext();
            if (b1 != null) b1 = b1.getNext();
        }
        if (carry > 0) {
            curr.setNext(new Node(carry));
        }
        return head;
    }


    public static void main(String[] args){
    }
}
