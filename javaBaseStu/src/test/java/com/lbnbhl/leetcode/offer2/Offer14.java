package com.lbnbhl.leetcode.offer2;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @autor wwl
 * @date 2023/1/22-21:26
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 * 解：华东窗口+hashset
 */
public class Offer14 {

    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < n; ++i) {
            --cnt[s1.charAt(i) - 'a'];
        }
        int left = 0;
        for (int right = 0; right < m; ++right) {
            int x = s2.charAt(right) - 'a';
            ++cnt[x];
            while (cnt[x] > 0) {
                --cnt[s2.charAt(left) - 'a'];
                ++left;
            }
            if (right - left + 1 == n) {
                return true;
            }
        }
        return false;
    }

    public boolean checkInclusion1(String s1, String s2) {
//        length滑动窗口大小,
        int length = s1.length(),i=0,j=0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char c : s1.toCharArray()) {
            if (hashMap.containsKey(c))
                hashMap.put(c,hashMap.get(c)+1);
            else 
                hashMap.put(c,1);
        }

        HashMap<Character, Integer> clone = (HashMap<Character, Integer>) hashMap.clone();

        char[] chars = s2.toCharArray();
        for (int i1 = 0; i1 < chars.length; i1++) {
            Character c=chars[i1];
            if (hashMap.containsKey(c)){
                if (j-i+1<length ){
                    j=i1;
                    hashMap.put(chars[i],hashMap.get(chars[i])-1);
                }else {
                    hashMap.put(chars[i],hashMap.get(chars[i])+1);
                    i++;
                }
//                if (hashMap.get(c)<=0){
//                    if (chars[i]==c) {
//                        j=i1;
//                        i++;
//                    }else {
//                        while (i<i1){
//                            hashMap.put(chars[i],hashMap.get(chars[i])+1);
//                            i++;
//                        }
//                        i=i1+1;
//                        continue;
//                    }
//                }
            }else {
                while (i<i1){
                    hashMap.put(chars[i],hashMap.get(chars[i])+1);
                    i++;
                }
                i=i1+1;
            }

            if (j-i+1==length) return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Offer14 offer14 = new Offer14();
        boolean b = offer14.checkInclusion("adc","dcda");
        System.out.println(b);
    }
}
