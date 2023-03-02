package com.lbnbhl.leetcode.offer1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行
 * @autor wwl
 * @date 2022/9/16-16:07
 */
public class Offer32_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<List<Integer>> list = new ArrayList<>();
        if (root==null) return list;
        queue.add(root);
        while (!queue.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<>();
            int i,j=queue.size();
            for (i = 0; i < j; i++) {
                TreeNode poll = queue.poll();
                temp.add(poll.val);
                if (poll.left!=null) queue.add(poll.left);
                if (poll.right!=null) queue.add(poll.right);
            }
            list.add(temp);
        }
        return list;
    }
}
