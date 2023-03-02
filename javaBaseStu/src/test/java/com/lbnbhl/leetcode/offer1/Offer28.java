package com.lbnbhl.leetcode.offer1;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * @autor wwl
 * @date 2022/9/17-15:30
 * isSymmetric(root) ：
 *
 * 特例处理： 若根节点 root 为空，则直接返回 truetrue 。
 * 返回值： 即 recur(root.left, root.right) ;
 * recur(L, R) ：
 *
 * 终止条件：
 * 当 LL 和 RR 同时越过叶节点： 此树从顶至底的节点都对称，因此返回 truetrue ；
 * 当 LL 或 RR 中只有一个越过叶节点： 此树不对称，因此返回 falsefalse ；
 * 当节点 LL 值 \ne
 * 
 *  = 节点 RR 值： 此树不对称，因此返回 falsefalse ；
 * 递推工作：
 * 判断两节点 L.leftL.left 和 R.rightR.right 是否对称，即 recur(L.left, R.right) ；
 * 判断两节点 L.rightL.right 和 R.leftR.left 是否对称，即 recur(L.right, R.left) ；
 * 返回值： 两对节点都对称时，才是对称树，因此用与逻辑符 && 连接。
 */
public class Offer28 {
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        return   recur(root.left,root.right);
    }

    boolean recur(TreeNode left,TreeNode right){
        if (left==null && right==null) return true;
        else if (left!=null && right!=null && right.val==left.val)
        return recur(left.left,right.right) && recur(left.right,right.left);
        else return false;
    }
}