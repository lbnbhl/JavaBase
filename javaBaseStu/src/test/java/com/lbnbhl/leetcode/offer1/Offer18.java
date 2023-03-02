package com.lbnbhl.leetcode.offer1;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *返回删除后的链表的头节点
 * @autor wwl
 * @date 2022/9/21-9:08
 */
public class Offer18 {

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        ListNode pre=new ListNode();
        pre.next=head;
        ListNode p=head;
        head=pre;
        while (p!=null){
            if (p.val==val){
                pre.next=p.next;
                pre=p.next;
            }
            pre=p;
            p=pre.next;
        }
        return head.next;
    }
}
