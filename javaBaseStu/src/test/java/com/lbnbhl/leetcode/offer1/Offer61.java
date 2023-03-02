package com.lbnbhl.leetcode.offer1;

/**
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14
 * @autor wwl
 * @date 2022/9/26-20:36
 */
public class Offer61 {
    public boolean isStraight(int[] nums) {
        int count=0,temp1;
        //进行length-1轮
        for (int i = nums.length; i > 1; i--) {
            //每轮比较i-1次
            for (int j = 0; j < i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i]==0) count++;
            if (nums[i]!=0){
                temp1=nums[i+1]-nums[i];
                if (temp1==0) return false;
                if (temp1>1)
                    count=count-temp1+1;
            }
        }
        if (count>=0) return true;
        else return false;
    }
}
