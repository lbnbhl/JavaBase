package com.lbnbhl.leetcode.hot;


import com.lbnbhl.leetcode.ListNode;
import org.junit.Test;

/**
 * @autor wwl
 * @date 2023/1/11-16:43
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class Hot2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int ca=0;
        ListNode res=new ListNode();
        ListNode p=res;
        while (l1 != null && l2 != null){
            p.val=l1.val+ l2.val+ca;
            ca=0;
            if (p.val>=10){
                ca=1;
                p.val-=10;
            }
            l1=l1.next;
            l2=l2.next;
            p.next=new ListNode();
            p=p.next;
        }
        if (l1==null && l2==null){
            if ( ca==1 ){
                p.val=1;
            }else p=null;
        }
//        if (l1 == null){
//            p
//        }
//
//        if (l2==null){
//
//        }
/*        if (l1 == null){
            if (ca==1){
                if (l2==null){
                    p.val=1;
                }else {
                    while (ca==1){
                        p.val= l2.val+ca;
                        ca=0;
                        if (p.val>=10){
                            ca=1;
                            p.val-=10;
                        }
                        l2=l2.next;
                        p.next=new ListNode();
                        p=p.next;
                    }
                    if (l2==null){
                        p.val=1;
                    }
                }
            }else {
                if (l2==null) {
                    p=null;
                }
                else p=l2;
            }
        }else {
            if (ca==1){
                l1.val++;
            }
            p=l1;
        }*/
        return res;
    }


    @Test
    public void addTwoNumbersTest(){
        ListNode l1=new ListNode(2,new ListNode(4,new ListNode(3)));
        ListNode l2=new ListNode(5,new ListNode(6,new ListNode(4)));
        ListNode listNode = addTwoNumbers(l1, l2);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
        System.out.println(listNode);
    }

}
