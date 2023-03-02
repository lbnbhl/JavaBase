package com.lbnbhl.leetcode.offer1;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，
 * 序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 * @autor wwl
 * @date 2022/10/5-22:51
 */
public class Offer31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0, j = 0, temp = 0;
        Queue<Integer> stack = new ArrayDeque();
        while (j < popped.length - 1) {
            if (pushed[i] != popped[j]) {
                stack.add(pushed[i++]);
            } else {
                j++;
            }
            if (stack.isEmpty()) return true;
            else return false;
        }
        return false;
    }
}