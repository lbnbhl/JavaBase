package com.lbnbhl.leetcode.offer2;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @autor wwl
 * @date 2023/1/16-14:29
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 */
public class Offer11 {

    // 前缀和：       0的话-1，1的话+1,(j,i]结果为0符合要求
    public int findMaxLength(int[] nums) {
        int res=0,n= nums.length;
        int[] sums = new int[n + 1];
//        sums[0]=nums[0]==0?-1:1;
        for (int i = 1; i < n+1; i++) {
            sums[i]=nums[i-1]==0?sums[i-1]-1:sums[i-1]+1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < n+1; i++) {
//            Integer put = map.put(sums[i], i);
            if (!map.containsKey(sums[i])) {
                map.put(sums[i],i);
            }else {
                res= Math.max(i - map.get(sums[i] ) , res);
            }
            if ((map.containsKey(sums[i]-1)&&sums[i-1]<sums[i]) || map.containsKey(sums[i]+1)&&sums[i-1]>sums[i]) {
                res= Math.max(i - map.get(sums[i] - 1) + 1, res);
            }
        }
        return res;
    }

    @Test
    public void findMaxLengthTest(){
        int[] nums=new int[]{1,1,1,1,1,1,1,1};
//        int[] nums=new int[]{0,0,1,0,0,0,1,1};
        System.out.println(findMaxLength(nums));
    }
}

//0  0  0  1  0  0  1  1  0  1  1  1  1  1
//-1 -2 -3 -2 -3 -4 -3 -2 -3 -2 -1 0  1  2
//
//sum[i]-sum[j]==-1
//sum[i]==sum[j]-1