package com.lbnbhl.leetcode.offer1;

import java.util.*;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * @autor wwl
 * @date 2022/9/25-19:58
 */
public class Offer34 {

    int res;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        dfs(root,temp,target,list);
        return list;
    }
    void dfs(TreeNode root,List<Integer> temp,int target,List<List<Integer>> list){
        if (root==null) return;
        if (root.left == null && root.right == null && root.val + res == target) {
            if (root.val + res == target) {
                temp.add(root.val);
                list.add(new ArrayList<>(temp));
                temp.remove(temp.size()-1);
            }
            return;
        }
        res=res+root.val;
        temp.add(root.val);
        dfs(root.left,temp,target,list);
        dfs(root.right,temp,target,list);
        temp.remove(temp.size()-1);
        res-=root.val;
    }

}
