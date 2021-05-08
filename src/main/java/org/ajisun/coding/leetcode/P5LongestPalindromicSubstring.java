package org.ajisun.coding.leetcode;

//给你一个字符串 s，找到 s 中最长的回文子串。
//
//
//
// 示例 1：
//
//
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
//
//
// 示例 2：
//
//
//输入：s = "cbbd"
//输出："bb"
//
//
// 示例 3：
//
//
//输入：s = "a"
//输出："a"
//
//
// 示例 4：
//
//
//输入：s = "ac"
//输出："a"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 仅由数字和英文字母（大写和/或小写）组成

/**
 * @Copyright (c) 2021. ajisun. All right reserved.
 * @ProjectName: ajisun-leetcode
 * @PackageName: org.ajisun.coding.leetcode
 * @Date: 2021/4/14
 * @author: ajisun
 * @Email: sunj.guang@foxmail.com
 */
public class P5LongestPalindromicSubstring {

    public static void main(String[] args){
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome2("bbaabb"));

    }
    class Solution {
        public String longestPalindrome(String s) {


            return "";
        }


        /**
         * 中心扩展算法
         * @param s
         * @return
         */
        public String longestPalindrome2(String s) {
            if (s == null || s.length() < 1) {
                return "";
            }
            int start=0;
            int end = 0;
            for (int i=0;i<s.length();i++){
                // 奇数
                int len1 = expandAroundCenter(s,i,i);
                //偶数
                int len2 = expandAroundCenter(s,i,i+1);

                int len = Math.max(len1,len2);
                if (len> end-start){
                    start = i - (len-1)/2;
                    end = i+len/2;
                }

            }

            return s.substring(start, end + 1);
        }

        private int expandAroundCenter(String s, int left, int right){
            while (left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }
            return (right-1) - (left+1) +1;
        }







        /**
         * 暴力遍历(从短到长)
         * @param s
         * @return
         */
        public String longestPalindrome1(String s) {
            String ans = "";
            if (s==null || "".equals(s)){
                return "";
            }
            if (s.length()==1){
                return s;
            }
            int len = s.length();
            for (int i=0;i<len;i++){
                for (int j=i+1;j<=len;j++){
                    // 截取子字符串
                    String tmp = s.substring(i,j);
                    if (isPalindromic(tmp) && tmp.length()>ans.length()){
                        ans = tmp;
                    }
                }
            }
            return ans;
        }

        /**
         * 依次取出字符串对比两边是否相同
         * 从两边开始比对，如果有一个位置不相同就不是回文字符串
         * @param s
         * @return
         */
        private boolean isPalindromic(String s){
            int len = s.length();
            char[] chars = s.toCharArray();
            for (int i=0;i<len/2;i++){
                if (chars[i]!=chars[len-1-i]){
                    return false;
                }
            }
            return true;
        }



    }








}
