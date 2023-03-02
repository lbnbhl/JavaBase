package com.lbnbhl.leetcode.offer1;

/**
 * @autor wwl
 * @date 2022/9/28-8:57
 */
public class Offer55_1 {
    int res,max;
    public int maxDepth(TreeNode root) {
        dfs(root);

        return root==null?null:max+1;
    }
    void dfs(TreeNode root){
        if (root==null) return;
        if (root.right==null && root.left==null){
            max=Math.max(res,max);
        }
        res++;
        dfs(root.left);
        dfs(root.right);
        res--;
    }

    /**
     * 大老板，代码更简洁
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = maxDepth1(root.left);
        int right = maxDepth1(root.right);

        return Math.max(left+1, right+1);
    }
}
