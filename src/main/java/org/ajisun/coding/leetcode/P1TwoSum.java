package org.ajisun.coding.leetcode;



//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
//
// 你可以按任意顺序返回答案。
//
//
//
// 示例 1：
//
//
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
//
//
// 示例 2：
//
//
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
//
//
// 示例 3：
//
//
//输入：nums = [3,3], target = 6
//输出：[0,1]
//
//
//
//
// 提示：
//
//
// 2 <= nums.length <= 103
// -109 <= nums[i] <= 109
// -109 <= target <= 109
// 只会存在一个有效答案
//
// Related Topics 数组 哈希表

import java.util.HashMap;

/**
 * @Copyright (c) 2021. ajisun. All right reserved.
 * @ProjectName: ajisun-leetcode
 * @PackageName: org.ajisun.coding.leetcode
 * @Date: 2021/4/13
 * @author: ajisun
 * @Email: sunj.guang@foxmail.com
 */
public class P1TwoSum {


    public static void main(String[] args) {
        Solution solution = new P1TwoSum().new Solution();
        int[] nums = {3,2,4}; int target = 6;


//        System.out.println(solution.twoSum(nums,target));
        System.out.println(solution.twoSumHash(nums,target));
    }



    class Solution {
        public int[] twoSum(int[] nums, int target) {

            int n = nums.length;
            for (int i=0;i<n;++i){
                for (int j=i+1;j<n;++j){
                    if (nums[i]+nums[j]==target){
                        return new int[]{i,j};
                    }
                }
            }
            return new int[0];
        }

        /**
         * 通过hash表
         * @param nums
         * @param target
         * @return
         */
        public int[] twoSumHash(int[] nums, int target){

            HashMap<Integer,Integer> map = new HashMap<Integer, Integer>(nums.length);

            for (int i=0;i<nums.length;i++){
                if (map.containsKey(target-nums[i])){
                   return new int[]{map.get(target-nums[i]),i};
                }else {
                    map.put(nums[i],i);
                }
            }
            return new int[0];
        }

    }



}
