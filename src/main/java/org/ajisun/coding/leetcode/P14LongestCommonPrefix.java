package org.ajisun.coding.leetcode;

//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
//
//
// 示例 1：
//
//
//输入：strs = ["flower","flow","flight"]
//输出："fl"
//
//
// 示例 2：
//
//
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。
//
//
//
// 提示：
//
//
// 0 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] 仅由小写英文字母组成
//
// Related Topics 字符串

/**
 * @Copyright (c) 2021. ajisun. All right reserved.
 * @ProjectName: ajisun-leetcode
 * @PackageName: org.ajisun.coding.leetcode
 * @Date: 2021/5/19
 * @author: ajisun
 * @Email: ajisun
 */
public class P14LongestCommonPrefix {

    public static void main(String[] args) {
        Solution solution = new P14LongestCommonPrefix().new Solution();
        String[] strs = {"reflower","flow","flow"};
        System.out.println(solution.longestCommonPrefix(strs));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {

            String minStr = strs[0];
            for (String st : strs) {
                if (st.length() < minStr.length()) {
                    minStr = st;
                }
            }
            int len = minStr.length() - 1;
            int count = 0;
            while (len >= 0 && count!=strs.length) {
                count = 0;
                for (String st : strs) {
                    if (!st.contains(minStr)) {
                        break;
                    } else {
                        count += 1;
                    }
                }
                if (count == strs.length) {
                    break;
                }else {
                    minStr = minStr.substring(0, len);
                    len = minStr.length() - 1;
                }

            }

            return minStr;
        }
    }
}
