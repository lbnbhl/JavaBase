package com.lbnbhl.leetcode.offer1;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @autor wwl
 * @date 2023/2/21-15:34
 */
public class hhh {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int id=0;
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
//        队列辅助层序
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(root.val);
        res.add(list1);
        queue.addLast(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size>0) {
                TreeNode temp;
                if (id % 2 == 0)
                    temp = queue.pollLast();
                else
                    temp = queue.pollFirst();
                if (id % 2 == 0){
                    if (temp.left != null && temp.right != null){
                        queue.addLast(temp.left);
                        queue.addLast(temp.right);
                        list.add(temp.right.val);
                        list.add(temp.left.val);
                    }else if (temp.left != null){
                        queue.addLast(temp.left);
                        list.add(temp.left.val);
                    }else if (temp.right != null){
                        queue.addLast(temp.right);
                        list.add(temp.right.val);
                    }
                }else {
                    if (temp.left != null && temp.right != null){
                        queue.addLast(temp.left);
                        queue.addLast(temp.right);
                        list.add(temp.left.val);
                        list.add(temp.right.val);
                    }else if (temp.left != null){
                        queue.addLast(temp.left);
                        list.add(temp.left.val);
                    }else if (temp.right != null){
                        queue.addLast(temp.right);
                        list.add(temp.right.val);
                    }
                }
                size--;
            }
            id++;
            if (!list.isEmpty())
                res.add(list);
        }
        return res;
    }


    public static void main(String[] args) {
//        int a=5,b=5,c=4;
//        int res = (++a == b)?a:c--;
//        System.out.println(res);
        hhh hhh = new hhh();
//        int i = hhh.findSecondMinimumValue(
//                new TreeNode(1, new TreeNode(1, new TreeNode(1, new TreeNode(3, new TreeNode(3), new TreeNode(3)),
//                        new TreeNode(1, new TreeNode(1), new TreeNode(6))),
//                        new TreeNode(1, new TreeNode(1, new TreeNode(2), new TreeNode(1)), new TreeNode(1))),
//                        new TreeNode(3, new TreeNode(3, new TreeNode(3), new TreeNode(8)),
//                                new TreeNode(4, new TreeNode(4), new TreeNode(8)))));
//        hhh.lowestCommonAncestor(
//                new TreeNode(6,new TreeNode(2),new TreeNode(8)),new TreeNode(2),new TreeNode(8));
//
//
//            long a = Integer.MIN_VALUE;
//
//            System.out.println(a>b);
//
//    }

//        hhh.recoverTree(new TreeNode(3, new TreeNode(1), new TreeNode(4,new TreeNode(2),null)));

        hhh.zigzagLevelOrder(new TreeNode(0,new TreeNode(2,new TreeNode(1,new TreeNode(5),
                new TreeNode(1)),null),new TreeNode(4,new TreeNode(3,null,new TreeNode(6)),new TreeNode(-1,null,new TreeNode(8)))));
    }

}
