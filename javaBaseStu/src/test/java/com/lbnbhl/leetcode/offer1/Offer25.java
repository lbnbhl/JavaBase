package com.lbnbhl.leetcode.offer1;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * @autor wwl
 * @date 2022/9/22-16:17
 */
public class Offer25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null && l2==null) return null;
        if (l1==null) return l2;
        if (l2==null) return l1;
        ListNode h1=new ListNode();
        ListNode h2=h1;
        while (l1 !=null && l2 !=null){
            if (l1.val<l2.val) {
                h1.next=l1;
                l1=l1.next;
            }
            else {
                h1.next=l2;
                l2=l2.next;
            }
            h1=h1.next;
        }
        if (l1 == null)
            h1.next=l2;
        if (l2 == null)
            h1.next=l1;
        return h2.next;
    }
}
