package org.ajisun.coding.firstalgorithmbook.sort;

/**
 * 在插入排序中，需要将取出的数据与其左边的数字进行比较。就跟前面讲的步骤一样，如果左边的数字更小，就不需要继续比较，本轮操作到此结束，
 * 自然也不需要交换数字的位置。
 * <p>
 * 然而，如果取出的数字比左边已归位的数字都要小，就必须不停地比较大小，交换数字，直到它到达整个序列的最左边为止。
 * <p>
 * 时间复杂度和冒泡排序的一样，都为 O(n²)
 */


import java.util.Arrays;

/**
 * @Copyright (c) 2021. ajisun. All right reserved.
 * @ProjectName: ajisun-leetcode
 * @PackageName: org.ajisun.coding.firstalgorithmbook.sort
 * @Date: 2021/5/29
 * @author: ajisun
 * @Email: ajisun
 */
public class InsertSort {


    public static void main(String[] args) {

        int[] nums = {5, 3, 8, 4, 2, 1, 9, 7, 6, 500, 100, 300, 200, 400};

        // 每个数字都从要比对一遍
        for (int i = 0; i < nums.length; i++) {
            // 从当前位置的左边开始
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    // 如果右边的数比左边的小，就交换位置
                    nums[j] = nums[j] ^ nums[j - 1];
                    nums[j - 1] = nums[j] ^ nums[j - 1];
                    nums[j] = nums[j] ^ nums[j - 1];
                } else {
                    // 如果右边的数比左边的大，就结束这轮对比
                    break;
                }

            }
        }

        System.out.println(Arrays.toString(nums));

    }


}
