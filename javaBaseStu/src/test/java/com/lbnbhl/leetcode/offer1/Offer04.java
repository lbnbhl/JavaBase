package com.lbnbhl.leetcode.offer1;

import org.junit.Test;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @autor wwl
 * @date 2022/9/15-19:27
 */
public class Offer04 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while(i >= 0 && j < matrix[0].length)
        {
            if(matrix[i][j] > target) i--;
            else if(matrix[i][j] < target) j++;
            else return true;
        }
        return false;
    }
    //    作者：jyd
//    链接：https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/solution/mian-shi-ti-04-er-wei-shu-zu-zhong-de-cha-zhao-zuo/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

//    public boolean findNumberIn2DArray(int[][] matrix, int target) {
//        int[] nums=matrix[0];
//        int left=0,right= nums.length-1,mid=(left+right)/2;
////        while ()
//        while ( mid>=left && mid<=right && nums[mid]!=target ){
//            if ( target<nums[mid] ){
//                right=mid-1;
//            }else {
//                left=mid+1;
//            }
//            mid=(left+right)/2;
//        }
//        if (nums[mid]==target){
//            return true;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (matrix[mid][i]==target){
//                return true;
//            }
//        }
//        return false;
//    }

    @Test
    public void findNumberIn2DArrayTest(){
        int[][] nums=new int[][]{{1,2},{3,4},{5,6}};
//        int[] num=nums[0];
//        for (int i = 0; i < num.length; i++) {
//            System.out.println(num[i]);
//        }
//        System.out.println(num);
//        System.out.println(findNumberIn2DArray(nums, 5));
    }
}
