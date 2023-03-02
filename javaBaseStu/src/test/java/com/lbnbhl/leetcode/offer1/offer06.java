package com.lbnbhl.leetcode.offer1;

/**输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * @autor wwl
 * @date 2022/9/12-8:50
 */
public class offer06 {
    public int[] reversePrint(ListNode head) {
        if (head==null){return new int[0];}

        int[] result0=new int[10000];
        int i=0;
        for (i=0;head.next!=null;i++){
            result0[i]= head.val;
            head=head.next;
        }
        result0[i]= head.val;
        int[] result1=new int[i+1];
        for (int k = 0; k < i+1; k++) {
            result1[k]=result0[i-k];
        }
        return result1;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    ListNode(){}
}