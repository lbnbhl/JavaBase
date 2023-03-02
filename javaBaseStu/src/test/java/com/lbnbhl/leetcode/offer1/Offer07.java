package com.lbnbhl.leetcode.offer1;

import org.junit.Test;

/**
 * @autor wwl
 * @date 2022/9/30-22:02
 */
public class Offer07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder==null) return null;
        int cur=0,i=-1,j=-1;
        TreeNode root=new TreeNode(preorder[cur++]);
        TreeNode temp=root;
        while (cur<preorder.length){
//            temp=new TreeNode(preorder[cur-1]);
            for (int k = 0; k < inorder.length; k++) {
                if (preorder[cur-1]==inorder[k])
                    i=k;
                if (preorder[cur]==inorder[k])
                    j=k;
                if (i!=-1 && j!=-1) break;

            }
            if (j<i)
                temp.left=new TreeNode(preorder[cur]);
            else
                temp.right=new TreeNode(preorder[cur]);
            i=-1;
            j=-1;
            cur++;
        }
        return root;
    }

    @Test
    public void buildTreeTest(){
//        int[] preorder=new int[]{3,9,20,15,7};
//        int[] inorder=new int[]{9,3,15,20,7};
//        buildTree(preorder,inorder);
        double x=2.00000;
        System.out.println(myPow(x, -2));
    }

    public double myPow(double x, int n) {
        double res = 1;
        if (n > 0) {
            for (int i = 0; i < n; i++)
                res *= x;
        } else if (n == 0) return 1;
        else {
            for (int i = 0; i < -n; i++) {
                res *= (1.0 / x);
            }
        }
        return res;
    }

    public boolean verifyPostorder(int[] postorder) {
        return false;
    }

}
