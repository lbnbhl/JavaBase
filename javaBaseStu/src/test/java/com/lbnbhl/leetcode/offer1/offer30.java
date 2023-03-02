package com.lbnbhl.leetcode.offer1;

/**定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * @autor wwl
 * @date 2022/9/11-10:56
 */
public class offer30 {

    private Node head;

    public offer30() {
    }

    public void push(int x) {
        if (head==null){
            head=new Node(x,x,null);
        }else {
            head=new Node(x,x> head.min? head.min : x,head);
        }
    }

    public void pop() {
        head=head.next;
    }

    public int top() {
        return head.top;
    }

    public int min() {
        return head.min;
    }
}

class Node{

    int top;
    int min;
    Node next;

    public Node(int top, Integer min, Node next) {
        this.top = top;
        this.min = min;
        this.next = next;
    }

}
