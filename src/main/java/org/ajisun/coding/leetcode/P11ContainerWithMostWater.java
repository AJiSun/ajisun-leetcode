package org.ajisun.coding.leetcode;

//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i,
//ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
// 说明：你不能倾斜容器。
//
//
//
// 示例 1：
//
//
//
//
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
//
// 示例 2：
//
//
//输入：height = [1,1]
//输出：1
//
//
// 示例 3：
//
//
//输入：height = [4,3,2,1,4]
//输出：16
//
//
// 示例 4：
//
//
//输入：height = [1,2,1]
//输出：2
//
//
//
//
// 提示：
//
//
// n = height.length
// 2 <= n <= 3 * 104
// 0 <= height[i] <= 3 * 104
//
// Related Topics 数组 双指针
// 👍 2462 👎 0


/**
 * @Copyright (c) 2021. ajiisun. All right reserved.
 * @ProjectName: ajisun-leetcode
 * @PackageName: org.ajisun.coding.leetcode
 * @Date: 2021/5/17
 * @author: ajisun
 * @Email: ajisun
 */
public class P11ContainerWithMostWater {

    public static void main(String[] args){
        Solution solution = new P11ContainerWithMostWater().new Solution();
        int[] heigth = {1,8,6,2,5,4,8,3,7};
        System.out.println(solution.maxArea2(heigth));
    }



    class Solution {


        /**
         * 暴力解法
         * @param height
         * @return
         */
        public int maxArea(int[] height) {

            int maxArea = 0;
            for (int i=1;i<height.length;i++){
                for (int y=0;y<i;y++){
                    int area = Math.min(height[y],height[i])*(i-y) ;
                    maxArea = Math.max(maxArea,area);
                }
            }

            return maxArea;
        }

        /**
         * 双指针
         * @param height
         * @return
         */
        public int maxArea2(int[] height){

            int left = 0;
            int right = height.length-1;
            int max = 0;

            while (left<right){
                int leftH = height[left];
                int rightH = height[right];
                max = Math.max(Math.min(leftH,rightH)*(right-left),max);
                if (leftH>rightH){
                    right = right-1;
                }else {
                    left = left+1;
                }
            }

            return max;
        }



    }

}
