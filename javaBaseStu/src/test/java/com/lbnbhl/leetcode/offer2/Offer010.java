package com.lbnbhl.leetcode.offer2;

import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

/**
 * @autor wwl
 * @date 2022/11/19-14:26
 * 给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。
 * 前缀和
 */
public class Offer010 {

    public int subarraySum(int[] nums, int k) {
        int res=0,sum=0;
        int[] map=new int[nums.length+1];
        map[0]=0;
        for (int i = 0; i < nums.length; i++) {
            map[i+1]=sum+=nums[i];
            for (int j = 0; j <= i; j++) {
                int temp=sum-map[j];
                if (temp==k) res++;
            }
        }
        return res;
    }


//    前缀和 + 哈希表
//    这是一道经典的前缀和运用题。
//    统计以每一个 nums[i]为结尾，和为 k 的子数组数量即是答案。
//    我们可以预处理前缀和数组 sum（前缀和数组下标默认从 1 开始），
//    对于求解以某一个 nums[i] 为结尾的，和为 k 的子数组数量，
//    本质上是求解在 [0,i] 中，sum 数组中有多少个值为 sum[i+1]−k 的数，
//    这可以在遍历过程中使用「哈希表」进行同步记录。
//    作者：宫水三叶
    public int subarraySum1(int[] nums, int k) {
        int n = nums.length, ans = 0;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + nums[i - 1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 1; i <= n; i++) {
            int t = sum[i], d = t - k;
            ans += map.getOrDefault(d, 0);
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        return ans;
    }

    public int subarraySum2(int[] nums, int k) {
        return 0;
    }


    @Test
    public void subarraySumTest(){
        int[] nums=new int[]{-1,-1,-1};
        System.out.println(subarraySum1(nums, 0));
    }
}
