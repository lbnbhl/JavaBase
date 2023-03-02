package com.lbnbhl.leetcode.offer1;

/**
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值
 * @autor wwl
 * @date 2022/9/25-22:30
 */
public class Offer54 {
    int i=0,flag=0;
    int res;
    public int kthLargest(TreeNode root, int k) {
        maxk(root,k);
        return res;
    }
    void maxk(TreeNode root, int k) {
        if (root == null) {
            flag = 1;
            return;
        }
        maxk(root.right, k);

        while (flag == 1) {
            i++;
            if (i == k) {
                res = root.val;
                return;
            }
            maxk(root.left, k);
            return;
        }
    }
}
