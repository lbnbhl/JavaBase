package com.lbnbhl.leetcode.offer1;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * @autor wwl
 * @date 2022/9/29-20:24
 */
public class Offer68_1 {

    int flag;
    List<List<TreeNode>> list=new ArrayList<>();
    List<TreeNode> temp=new ArrayList<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        int len,i;
        TreeNode res;
        dfs(root,p,q);
        List<TreeNode> list1 = list.get(0);
        List<TreeNode> list2 = list.get(1);
        len=Math.min(list1.size()-1,list2.size()-1);
        for (i = 0; i < len; i++) {
            if (list1.get(i) != list2.get(i)){
                break;
            }
        }
        res=list1.get(i-1);
        return res;
    }
    void dfs(TreeNode root,TreeNode p,TreeNode q){
        if (root == null || flag==2) return;
        temp.add(root);
        if (root == p || root==q){
            flag++;
            list.add(new ArrayList<>(temp));
        }
        dfs(root.left,p,q);
        dfs(root.right,p,q);
        temp.remove(temp.size()-1);
        return;
    }

//    int flag;
//    List<TreeNode> list=new ArrayList<>();
//    TreeNode temp=new TreeNode();
//
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null) return null;
//        int len,i;
//        TreeNode res;
//        temp=root;
//        dfs(root,p,q);
//        TreeNode list1 = list.get(0);
//        TreeNode list2 = list.get(1);
//        len=Math.min(list1.size()-1,list2.size()-1);
//        for (i = 0; i < len; i++) {
//            if (list1.get(i) != list2.get(i)){
//                break;
//            }
//        }
//        res=list1.get(i-1);
//        return res;
//    }
//    void dfs(TreeNode root,TreeNode p,TreeNode q){
//        if (root == null || flag==2) return;
//        temp=
//        if (root == p || root==q){
//            flag++;
//            list.add(new ArrayList<>(temp));
//        }
//        dfs(root.left,p,q);
//        dfs(root.right,p,q);
//        temp.remove(temp.size()-1);
//        return;
//    }
}
