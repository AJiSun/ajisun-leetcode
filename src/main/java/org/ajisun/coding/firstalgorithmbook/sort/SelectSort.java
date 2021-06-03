package org.ajisun.coding.firstalgorithmbook.sort;


/**
 * 选择排序：
 * 每次获取未排序中最小的值和左边交换位置
 *
 *
 *选择排序使用了线性查找来寻找最小值，因此在第 1 轮中需要比较 n -1 个数字，第 2 轮需要比较 n -2 个数字……到第 n -1 轮的时候就只需比较 1 个数字了。
 * 因此，总的比较次数与冒泡排序的相同，都是 (n-1)+(n-2)+…+1 ≈ n²/2 次。 每轮中交换数字的次数最多为 1 次。如果输入数据就是按从小到大的顺序排列的，
 * 便不需要进行任何交换。选择排序的时间复杂度也和冒泡排序的一样，都为 O(n²)。
 *
 */


import java.util.Arrays;

/**
 * @Copyright (c) 2021. ajisun. All right reserved.
 * @ProjectName: ajisun-leetcode
 * @PackageName: org.ajisun.coding.firstalgorithmbook.sort
 * @Date: 2021/5/28
 * @author: ajisun
 * @Email: ajisun
 */
public class SelectSort {

    /**
     * n个数字循环n次，每次把剩下最小值的下标记录下来，然后和当前位置交换
     * @param args
     */
    public static void main(String[] args) {

        int[] nums = {5, 3, 8, 4, 2, 1, 9, 7, 6,500,100,300,200,400};

        for (int i=0;i<nums.length;i++){
            int n = i;
            for (int j=i;j<nums.length;j++){
                if (nums[n]>nums[j]){
                    n = j;
                }
            }
            if (i!=n){
                nums[i] = nums[i] ^ nums[n];
                nums[n] = nums[i] ^ nums[n];
                nums[i] = nums[i] ^ nums[n];
            }
        }

        System.out.println(Arrays.toString(nums));

    }


}
