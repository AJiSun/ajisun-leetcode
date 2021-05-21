package org.ajisun.coding.leetcode;


//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。
//
//
//
// 示例：
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
//
//
//
//
// 提示：
//
//
// 3 <= nums.length <= 10^3
// -10^3 <= nums[i] <= 10^3
// -10^4 <= target <= 10^4
//
// Related Topics 数组 双指针

import java.util.Arrays;

/**
 * @Copyright (c) 2021. ajisun. All right reserved.
 * @ProjectName: ajisun-leetcode
 * @PackageName: org.ajisun.coding.leetcode
 * @Date: 2021/5/21
 * @author: ajisun
 * @Email: ajisun
 */
public class P16ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new P16ThreeSumClosest().new Solution();
        System.out.println(solution.threeSumClosest(new int[]{-1,2,1,-4},1));
    }

    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);

            int threeNum0 = nums[0] + nums[1] + nums[2];
            for (int i = 0; i < nums.length; i++) {
                int l = i + 1, r = nums.length - 1;
                while (l < r) {
                    int threeSum = nums[i] + nums[l] + nums[r];
                    if (Math.abs(threeNum0 - target) > Math.abs(threeSum - target)) {
                        threeNum0 = threeSum;
                    }
                    if (threeSum > target) {
                        r--;
                    } else if (threeSum < target) {
                        l++;
                    } else {
                        return threeNum0;
                    }

                }

            }
            return threeNum0;
        }
    }
}
