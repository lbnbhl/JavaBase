package com.lbnbhl.leetcode.offer1;

/**
 *请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * @autor wwl
 * @date 2022/9/17-15:14
 */
public class Offer27 {
    public TreeNode mirrorTree(TreeNode root) {
        TreeNode temp;
        if (root!=null){
            temp=root.left;
            root.left=root.right;
            root.right=temp;
        }else
            return null;
        if (root.left!=null)
            mirrorTree(root.left);
        if (root.right!=null)
            mirrorTree(root.right);
        return root;
    }
}
