package com.lbnbhl.leetcode.offer1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * @autor wwl
 * @date 2022/9/16-14:46
 */
public class Offer32_1 {
    public int[] levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<TreeNode> list = new ArrayList<>();
        if (root==null) return new int[0];
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            list.add(poll);
            if (poll.left!=null) queue.add(poll.left);
            if (poll.right!=null) queue.add(poll.right);
        }
        int[] result=new int[list.size()];
        int i=0;
        for (TreeNode treeNode : list) {
            result[i++]= treeNode.val;
        }
        return result;
    }

}
