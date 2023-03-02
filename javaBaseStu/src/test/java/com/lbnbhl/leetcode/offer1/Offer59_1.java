package com.lbnbhl.leetcode.offer1;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值
 * @autor wwl
 * @date 2022/10/7-10:37
 */
public class Offer59_1 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int max=Integer.MIN_VALUE,lt= Math.min(k, nums.length),left=0,right=k-1,len=nums.length-k+1,cur=0,index = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < lt; i++) {
            if (max<=nums[i]){
                max=nums[i];
                index=i;
            }
        }
        map.put(index,max);
        if (nums.length<=k) return new int[]{max};
        int[] res=new int[len];
        res[cur++]=max;
        while (true){
            right++;
            int num=nums[right];
            if (left<index){
                if (num>=map.get(index)) {
                    index=right;
                    map.put(index,num);
                }
                num=num>map.get(index)?num:map.get(index);
                res[cur++]=num;
            }else if (left==index){
                max=Integer.MIN_VALUE;
                for (int i = left+1; i <= right; i++) {
                    if (max<=nums[i]){
                        max=nums[i];
                        index=i;
                    }
                }
                map.put(index,max);
                res[cur++]=max;
            }
            if (cur==len) break;
            left++;
        }
        return res;
    }

    @Test
    public void maxSlidingWindowTest(){

        int[] nums=new int[]{-6,-10,-7,-1,-9,9,-8,-4,10,-5,2,9,0,-7,7,4,-2,-10,8,7};
        int k=7;
        for (int i : maxSlidingWindow(nums, k)) {
            System.out.println(i);
        }
    }
}
