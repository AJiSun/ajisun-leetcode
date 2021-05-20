package org.ajisun.coding.leetcode;


//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
//
//
// 示例 1：
//
//
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//
//
// 示例 2：
//
//
//输入：nums = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：nums = [0]
//输出：[]
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 3000
// -105 <= nums[i] <= 105
//
// Related Topics 数组 双指针


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Copyright (c) 2021. ajisun. All right reserved.
 * @ProjectName: ajisun-leetcode
 * @PackageName: org.ajisun.coding.leetcode
 * @Date: 2021/5/20
 * @author: ajisun
 * @Email: ajisun
 */
public class P15ThreeSum {
    public static void main(String[] args) {
        Solution solution = new P15ThreeSum().new Solution();
        System.out.println(solution.threeSum(new int[] {-1,0,1,2,-1,-4}));
    }

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {

            List<List<Integer>> result = new ArrayList<List<Integer>>();
            int l, r, sum, n = nums.length;
            Arrays.sort(nums);

            for (int i = 0; i < n; i++) {
                if (i != 0 && nums[i] == nums[i - 1]) {
                    continue;
                } else if (nums[i] > 0) {
                    return result;
                } else {
                    l = i + 1;
                    r = n - 1;
                    while (l < r) {
                        sum = nums[i] + nums[l] + nums[r];
                        if (sum == 0) {
                            result.add(Arrays.asList(nums[i], nums[l++], nums[r--]));
                            while (l < r && nums[l] == nums[l - 1]) {
                                l++;
                            }
                            while (l < r && nums[r] == nums[r + 1]) {
                                r--;
                            }
                        } else if (sum < 0) {
                            l++;
                        } else {
                            r--;
                        }
                    }
                }
            }
            return result;

        }
    }
}
