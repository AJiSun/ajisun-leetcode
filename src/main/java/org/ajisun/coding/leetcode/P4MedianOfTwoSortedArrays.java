package org.ajisun.coding.leetcode;


//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
//
//
//
// 示例 1：
//
//
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
//
//
// 示例 2：
//
//
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
//
//
// 示例 3：
//
//
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
//
//
// 示例 4：
//
//
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
//
//
// 示例 5：
//
//
//输入：nums1 = [2], nums2 = []
//输出：2.00000
//
//
//
//
// 提示：
//
//
// nums1.length == m
// nums2.length == n
// 0 <= m <= 1000
// 0 <= n <= 1000
// 1 <= m + n <= 2000
// -106 <= nums1[i], nums2[i] <= 106
//
//
//
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
// Related Topics 数组 二分查找 分治算法

/**
 * @Copyright (c) 2021. ajisun. All right reserved.
 * @ProjectName: ajisun-leetcode
 * @PackageName: org.ajisun.coding.leetcode
 * @Date: 2021/4/14
 * @author: ajisun
 * @Email: sunj.guang@foxmail.com
 */
public class P4MedianOfTwoSortedArrays {


    public static void main(String[] args){
        Solution solution = new P4MedianOfTwoSortedArrays().new Solution();

        int[] nums1={1,2,9};
        int[] nums2 ={3,4,5,9,10};
        System.out.println(solution.findMedianSortedArrays(nums1,nums2));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        /**
         * 合并两个有序数组，然后获取中位数
         * @param nums1
         * @param nums2
         * @return
         */
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {

            int [] newNum = new int[nums1.length+nums2.length];
            int k = 0;

            int i =0;
            int j = 0;
            while (i<nums1.length && j<nums2.length){

                if (nums1[i]<=nums2[j]){
                    newNum[k] = nums1[i];
                    i++;
                }else {
                    newNum[k] = nums2[j];
                    j++;
                }
                k++;
            }

            if (i<nums1.length){
                for (int n=i;n<nums1.length;n++) {
                    newNum[k] = nums1[n];
                    k++;
                }
            }

            if (j<nums2.length){
                for (int n=j;n<nums2.length;n++) {
                    newNum[k] = nums2[n];
                    k++;
                }
            }

            for (int m=0;m<newNum.length;m++){
                System.out.println(newNum[m]);
            }

            int len = newNum.length;
            if (len%2==0){
                return  (double)(newNum[len/2-1] + newNum[len/2])/2L;
            }else {
                return  newNum[len/2];
            }

        }

    }
}
