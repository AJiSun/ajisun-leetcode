package org.ajisun.coding.firstalgorithmbook.sort;

import java.util.Arrays;


/**
 * 快速排序是一种“分治法”。它将原本的问题分成两个子问题（比基准值小的数和
 * 比基准值大的数），然后再分别解决这两个问题。子问题，也就是子序列完成排序后，
 * 再像一开始说明的那样，把他们合并成一个序列，那么对原始序列的排序也就完成了。
 * 不过，解决子问题的时候会再次使用快速排序，甚至在这个快速排序里仍然要使用
 * 快速排序。只有在子问题里只剩一个数字的时候，排序才算完成。
 */

/**
 * @Copyright (c) 2021. ajisun. All right reserved.
 * @ProjectName: ajisun-leetcode
 * @PackageName: org.ajisun.coding.firstalgorithmbook.sort
 * @Date: 2021/6/2
 * @author: ajisun
 * @Email: ajisun
 */
public class QuickSort {


    public static void main(String[] args) {
        int[] nums = {5, 3, 8, 4, 2, 1, 9, 7, 6,500,100,300,200,400};


        childrenQuickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));

    }


    private static   void  childrenQuickSort(int[] nums,int left,int right ){

        if (left<right){
            int pivot = nums[left];
            int i = left;
            int j = right;
            while (i<j){

                // 从右向左找，直到比基准值小
                while ((i<j) && nums[j]>=pivot){
                    j--;
                }
                // 从左向右找，直到比基准值大
                while ((i<j)&& nums[i]<=pivot){
                    i++;
                }

                // 如果不是同一个数，交换两个数
                if (i!=j){
                    nums[i] = nums[i] ^ nums[j];
                    nums[j] = nums[i] ^ nums[j];
                    nums[i] = nums[i] ^ nums[j];
                }

            }

            nums[left] = nums[i];
            nums[i] = pivot;
            childrenQuickSort(nums,left,j-1);
            childrenQuickSort(nums,i+1,right);

        }

    }


}
