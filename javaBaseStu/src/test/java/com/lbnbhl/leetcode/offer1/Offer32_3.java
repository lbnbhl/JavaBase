package com.lbnbhl.leetcode.offer1;

import java.util.*;

/**
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * @autor wwl
 * @date 2022/9/16-16:37
 */
public class Offer32_3 {
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
        for(int i=1;i<list.size();i+=2){
            Collections.reverse(list.get(i));
        }
        return list;
    }
}
