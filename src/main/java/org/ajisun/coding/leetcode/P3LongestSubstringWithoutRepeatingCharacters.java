package org.ajisun.coding.leetcode;

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
//
//
// 示例 1:
//
//
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
//
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
//
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
//
// 示例 4:
//
//
//输入: s = ""
//输出: 0
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 5 * 104
// s 由英文字母、数字、符号和空格组成
//
// Related Topics 哈希表 双指针 字符串 Sliding Window

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Copyright (c) 2021. ajisun. All right reserved.
 * @ProjectName: ajisun-leetcode
 * @PackageName: org.ajisun.coding.leetcode
 * @Date: 2021/4/13
 * @author: ajisun
 * @Email: sunj.guang@foxmail.com
 */
public class P3LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args){
        Solution solution = new P3LongestSubstringWithoutRepeatingCharacters().new Solution();


//        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring2(""));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s==null||s.length()==0){
                return 0;
            }
            Set<Character> set = new HashSet<Character>();
            char[] chars = s.toCharArray();
            int max = 0;
            for (int i=0;i<chars.length;i++){
                for (int j=i;j<chars.length;j++){
                    if (!set.contains(chars[j])){
                        set.add(chars[j]);
                    }else {
                        break;
                    }
                }
                max = set.size()>max?set.size():max;
                for (Character character:set){
                    System.out.print(character);
                }
                set.clear();
                System.out.println("===");
            }

            return max;

        }


        public int lengthOfLongestSubstring2(String s) {

            // 哈希集合，记录每个字符是否出现过
            Set<Character> occ = new HashSet<Character>();
            int n = s.length();
            // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
            int rk = -1, ans = 0;
            for (int i=0;i<n;i++){
                if (i!=0){
                    // 左指针向右移动一格，移除一个字符
                    occ.remove(s.charAt(i-1));
                }

                while (rk+1<n && !occ.contains(s.charAt(rk+1))){
                    occ.add(s.charAt(rk+1));
                    // 不断地移动右指针
                    rk++;
                }

                // 第 i 到 rk 个字符是一个极长的无重复字符子串
                ans = Math.max(ans, rk - i + 1);

            }

            return ans;
        }

    }

}
