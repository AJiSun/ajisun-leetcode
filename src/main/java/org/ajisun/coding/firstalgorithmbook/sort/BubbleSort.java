package org.ajisun.coding.firstalgorithmbook.sort;


/**
 * 《我的第一本算法书》
 * 冒泡排序：
 *
 * n个数字，外循环需要n次，内循环= (n - 外循环-1) ,每次循环都会把最大数字放在最后，所以不需要比对了
 *  1 轮需要比较 n -1 次，第 2 轮需要比较 n -2 次……第 n -1 轮需要比较 1 次
 *
 * 两个数字比较大小，然后会换位置
 * 交换数字的次数和输入数据的排列顺序有关。假设出现某种极端情况，如输
 * 入数据正好以从小到大的顺序排列，那么便不需要任何交换操作；反过来，输入数据要
 * 是以从大到小的顺序排列，那么每次比较数字后便都要进行交换。因此，冒泡排序的时
 * 间复杂度为 O(n²)。
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

public class BubbleSort {


    public static void main(String[] args) {


        int[] nums = {5, 3, 8, 4, 2, 1, 9, 7, 6,500,100,300,200,400};

        for (int j = 0; j < nums.length; j++) {
            for (int i = 0; i < nums.length - j - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    nums[i] = nums[i] ^ nums[i + 1];
                    nums[i + 1] = nums[i] ^ nums[i + 1];
                    nums[i] = nums[i + 1] ^ nums[i];
                }
            }
        }

        System.out.println(Arrays.toString(nums));

    }


    /**
     * 使用 异或 交换两个变量的值
     * 任意一个变量X与其自身进行异或运算，结果为0，即X^X=0
     * 任意一个变量X与0进行异或运算，结果不变，即X^0=X
     */
    private void exchange(){
        int a = 3, b = 4;
        a = a ^ b;
        b = a ^ b;
        a = b ^ a;
        System.out.println(a + "==" + b);
    }


}
