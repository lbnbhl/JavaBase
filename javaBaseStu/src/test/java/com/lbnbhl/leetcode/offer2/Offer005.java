package com.lbnbhl.leetcode.offer2;

import java.util.HashMap;
import java.util.Map;

/**
 * @autor wwl
 * @date 2022/11/14-23:21
 * 给定一个字符串数组 words，请计算当两个字符串 words[i] 和 words[j] 不包含相同字符时，
 * 它们长度的乘积的最大值。假设字符串中只包含英语的小写字母。如果没有不包含相同字符的一对字符串，返回 0。
 */
public class Offer005 {
// 位运算 + 预计算

// 时间复杂度：O((m + n)* n)

// 空间复杂度：O(n)

    public int maxProduct(String[] words) {

        // O(mn)

        Map<Integer, Integer> map = new HashMap<>();

        int n = words.length;

        for (int i = 0; i < n; i++) {

            int bitMask = 0;

            for (char c : words[i].toCharArray()) {

                bitMask |= (1 << (c - 'a'));

            }

            // there could be different words with the same bitmask

            // ex. ab and aabb

            map.put(bitMask, Math.max(map.getOrDefault(bitMask, 0), words[i].length()));

        }



        // O(n^2)

        int ans = 0;

        for (int x : map.keySet()) {

            for (int y : map.keySet()) {

                if ((x & y) == 0) {

                    ans = Math.max(ans, map.get(x) * map.get(y));

                }

            }

        }

        return ans;

    }

    public int maxProduct1(String[] words) {

        Map<Integer,Integer> map=new HashMap();

        int length = words.length;

        for (String c : words) {

            int bitMask=0;

            for (char c1 : c.toCharArray()) {
                bitMask |= (1 << (c1 - 'a'));
            }

            map.put(bitMask, Math.max(map.getOrDefault(bitMask, 0),c.length()));
        }

        int ans = 0;

        for (int x : map.keySet()) {

            for (int y : map.keySet()) {

                if ((x & y) == 0) {

                    ans = Math.max(ans, map.get(x) * map.get(y));

                }

            }

        }

        return ans;
    }



    public int maxProduct2(String[] words) {

        int[] binary = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            for (int j = words[i].length() - 1; j >= 0; j--) {
                binary[i] |= 1 << words[i].charAt(j) - 'a';
            }
        }

        int maxProduct = 0;

        for (int i = 1; i < words.length; i++) {
            for (int j = 0; j < i; j++) {
                if ((binary[i] & binary[j]) == 0) {
                    maxProduct = Math.max(maxProduct, words[i].length() * words[j].length());
                }
            }
        }

        return maxProduct;

    }

}
