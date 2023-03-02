package com.lbnbhl.leetcode.offer1;

import org.junit.Test;

/**
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * @autor wwl
 * @date 2022/10/2-16:31
 */
public class Offer56_2 {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }

    @Test
    public void singleNumberTest(){
        int[] nums=new int[]{3,4,3,3};
        System.out.println(singleNumber(nums));
    }
}
