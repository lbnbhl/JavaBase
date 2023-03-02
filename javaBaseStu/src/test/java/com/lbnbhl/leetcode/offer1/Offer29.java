package com.lbnbhl.leetcode.offer1;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * @autor wwl
 * @date 2022/10/5-21:38
 */
public class Offer29 {
    public int[] spiralOrder(int[][] matrix) {
        int m=matrix.length,n=matrix[0].length,len=m*n,i=0,j=0,cur=0,flag=0;
        if (m==0 || n==0) return null;
        int[] res=new int[len];
        while (cur < len) {
            if (flag % 4 ==0) {
                while (j + 1 <= m) {
                    res[cur++] = matrix[i][j];
                    j++;
                }
                flag++;
                j--;
                m--;

                break;
            }else if (flag%4==1){
                while (i+1<=n-1){
                    res[cur++] = matrix[i+1][j];
                    i++;
                }
                flag++;
                i--;
                n--;
                break;
            }else if (flag%4==2){
                int count=0;
                while (count++<m){
                    res[cur++] = matrix[i][j-1];
                    j--;
                }
                j++;
                m--;
                break;
            }else{
                int count=0;
                while (count++<n-1){
                    res[cur++] = matrix[i-1][j];
                    i--;
                }
                i++;
                n--;
                break;
            }
        }
        return res;
    }

    //大佬
    class Solution {
        public int[] spiralOrder(int[][] matrix) {
            if(matrix.length == 0) return new int[0];
            int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
            int[] res = new int[(r + 1) * (b + 1)];
            while(true) {
                for(int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right.
                if(++t > b) break;
                for(int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom.
                if(l > --r) break;
                for(int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left.
                if(t > --b) break;
                for(int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top.
                if(++l > r) break;
            }
            return res;
        }
    }

}
