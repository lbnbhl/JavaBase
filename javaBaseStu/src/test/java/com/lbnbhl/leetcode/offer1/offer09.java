package com.lbnbhl.leetcode.offer1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead操作返回 -1 )
 * @autor wwl
 * @date 2022/9/11-9:56
 */
public class offer09 {

    Deque A, B;

    public offer09() {
        A = new ArrayDeque<Integer>();
        B = new ArrayDeque<Integer>();
    }

    public void appendTail(int value) {
        A.addLast(value);
    }

    public int deleteHead() {
        if (!B.isEmpty()) {
            return (int) B.pop();
        } else if (A.isEmpty()) {
            return -1;
        } else {
            Object pop = A.pop();
            B.addLast(pop);
            return (int) B.pop();
        }
    }
}
