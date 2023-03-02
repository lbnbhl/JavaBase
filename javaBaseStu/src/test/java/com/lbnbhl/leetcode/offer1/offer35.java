package com.lbnbhl.leetcode.offer1;

import java.util.HashMap;

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 * 还有一个 random 指针指向链表中的任意节点或者 null。
 * @autor wwl
 * @date 2022/9/12-19:07
 */
public class offer35 {
    public Node1 copyRandomList(Node1 head) {
        if(head == null) return null;
        Node1 cur=head;
        HashMap<Node1, Node1> map = new HashMap<>();
        while (cur!=null){
            map.put(cur,new Node1(cur.var));
            cur=cur.next;
        }
        cur=head;
        while (cur!=null){
            map.get(cur).next=map.get(cur.next);
            map.get(cur).random=map.get(cur.random);
            cur=cur.next;
        }
        return map.get(head);
    }
}

class Node1{
    int var;
    Node1 next;
    Node1 random;
    Node1(int var){
        this.var=var;
        this.next=null;
        this.random=null;
    }
}
