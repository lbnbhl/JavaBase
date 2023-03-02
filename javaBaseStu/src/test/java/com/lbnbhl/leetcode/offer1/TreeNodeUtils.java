package com.lbnbhl.leetcode.offer1;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * @autor wwl
 * @date 2022/10/8-17:48
 */
public class TreeNodeUtils {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer res = new StringBuffer();
        if (root == null) return "[]";
        Deque<TreeNode> queue=new ArrayDeque();
        TreeNode temp=new TreeNode();
        queue.add(root);
        res.append("[").append(root.val).append(",");
        while (!queue.isEmpty()){
             temp=queue.pollFirst();
             if (temp.left != null) {
                 res.append(temp.left.val).append(",");
                 queue.addLast(temp.left);
             }else res.append("null").append(",");
             if (temp.right != null) {
                 res.append(temp.right.val).append(",");
                 queue.addLast(temp.right);
             }else res.append("null").append(",");
        }
        res.append("]");
        return String.valueOf(res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) return null;
        int i=1;
        String[] vals = data.substring(1, data.length() - 1).split(",");
        Deque<TreeNode> queue=new ArrayDeque();
        TreeNode res=new TreeNode(Integer.parseInt(vals[0].trim()));
        TreeNode temp=new TreeNode();
        queue.addLast(res);
        while (!queue.isEmpty()){
            temp=queue.removeFirst();
            if (!vals[i].equals("null")){
                TreeNode node=new TreeNode(Integer.parseInt(vals[i]));
                temp.left=node;
                queue.addLast(node);
            }
            i++;
            if (i==vals.length) return res;
            if (!vals[i].equals("null")){
                TreeNode node=new TreeNode(Integer.parseInt(vals[i]));
                temp.right=node;
                queue.addLast(node);
            }
            i++;
            if (i==vals.length) return res;
        }

        return res;

    }


////    大佬的
//    public TreeNode deserialize(String data) {
//        if(data.equals("[]")) return null;
//        String[] vals = data.substring(1, data.length() - 1).split(",");
//        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
//        Queue<TreeNode> queue = new LinkedList<>() {{ add(root); }};
//        int i = 1;
//        while(!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            if(!vals[i].equals("null")) {
//                node.left = new TreeNode(Integer.parseInt(vals[i]));
//                queue.add(node.left);
//            }
//            i++;
//            if(!vals[i].equals("null")) {
//                node.right = new TreeNode(Integer.parseInt(vals[i]));
//                queue.add(node.right);
//            }
//            i++;
//        }
//        return root;
//    }

    @Test
    public void deserializeTest(){
        String data="[1,2,3,null,null,4,5]";
        deserialize(data);
    }

}
