package com.lbnbhl.leetcode.offer1;

/**
 * @autor wwl
 * @date 2022/9/25-22:20
 */
class Node3 {
    public int val;
    public Node left;
    public Node right;

    public Node3() {}

    public Node3(int _val) {
        val = _val;
    }

    public Node3(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}