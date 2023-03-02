package com.lbnbhl.leetcode.offer1;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * @autor wwl
 * @date 2022/9/12-9:42
 */
public class offer24 {
    public ListNode reverseList(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode h1=new ListNode();
        ListNode h2=new ListNode();

        h1=h2=head;
        head=head.next;
        h1.next=null;
        while (head!=null){
            h2=head;
            head=head.next;
            h2.next=h1;
            h1=h2;
        }
        return h1;
    }
}