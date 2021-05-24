package org.ajisun.coding.leetcode;

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
//
//
// 示例 1：
//
//
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
//
//
// 示例 2：
//
//
//输入：digits = ""
//输出：[]
//
//
// 示例 3：
//
//
//输入：digits = "2"
//输出：["a","b","c"]
//
//
//
//
// 提示：
//
//
// 0 <= digits.length <= 4
// digits[i] 是范围 ['2', '9'] 的一个数字。
//
// Related Topics 深度优先搜索 递归 字符串 回溯算法


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Copyright (c) 2021. ajisun. All right reserved.
 * @ProjectName: ajisun-leetcode
 * @PackageName: org.ajisun.coding.leetcode
 * @Date: 2021/5/24
 * @author: ajisun
 * @Email: ajisun
 */
public class P17LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args){
        Solution solution = new P17LetterCombinationsOfAPhoneNumber().new Solution();
        System.out.println(solution.letterCombinations("23"));
    }
    class Solution {
        List<String> results = new ArrayList<String>();
        Map<Character,String> map = new HashMap<Character, String>(){
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };

        /**
         * 回溯，递归
         * @param digits
         * @return
         */
        public List<String> letterCombinations(String digits) {

            if(digits==null || digits.length()==0) {
                return results;
            }
            backtrack(digits, 0, new StringBuilder());


            return results;
        }


        private void backtrack(String str, int index,StringBuilder sb){

            if (index==str.length()){
                results.add(sb.toString());
                return;
            }

            char c = str.charAt(index);
            String mapStr = map.get(c);


            for(int i=0;i<mapStr.length();i++) {
                //调用下一层递归，用文字很难描述，请配合动态图理解
                sb.append(mapStr.charAt(i));
                //如果是String类型做拼接效率会比较低
                backtrack(str, index+1, sb);
                sb.deleteCharAt(sb.length()-1);
            }

        }

    }

}
