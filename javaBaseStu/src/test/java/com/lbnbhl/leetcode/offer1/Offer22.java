package com.lbnbhl.leetcode.offer1;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * @autor wwl
 * @date 2022/9/21-9:23
 */
public class Offer22 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head==null) return null;
        ListNode pre=head,p=pre;
        while (p!=null){
            if (k != 0) {
                p = p.next;
                k--;
            }else {
                pre=pre.next;
                p=p.next;
            }
        }
        return pre;
    }
}
