package org.ajisun.coding.leetcode;

/**
 * @Copyright (c) 2021. ajisun. All right reserved.
 * @ProjectName: ajisun-leetcode
 * @PackageName: org.ajisun.coding.leetcode
 * @Date: 2021/1/13
 * @author: ajisun
 * @Email: sunj.guang@foxmail.com
 */
public class ArrayMerge {


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 三指针 指针一p1、nums1有效元素尾部；指针二p2、nums2尾部；指针三p3、最终数组尾部
        // 1.当，p1>=0时，nums[p1],nums[p2]对比
        // 1.1 nums[p1]大，将nums[p1]放入p3位置。p1--,p3--
        // 1.2 nums[p2]大于等于nums[p1]，将nums[p2]放入p3位置。p2--,p3--
        // 2.当，p1<0时，将nums[p2]放入p3位置。p2--,p3--
        // 循环结束条件：p2<0
        int p1=m-1,p2=n-1,p3=m+n-1;
        while(p2 >= 0){
            if(p1 >= 0 && nums1[p1] > nums2[p2]){
                nums1[p3--] = nums1[p1--];
            } else {
                nums1[p3--] = nums2[p2--];
            }
        }
    }

    public static void findNums(int[] arr){
        int eor = 0;

        /**
         * 假设两个奇数是a和b
         * 最终 eor = a^b
         *     eor != 0
         *     eor位置上必然有一个1
         */
        for (int i=0;i<arr.length;i++){
            eor ^= arr[i];
        }
//        取出最右边的1(与上取反加1)
        int rightOne = eor & (~eor+1);
        // oer1'
        int onlyOne = 0;
        for (int i=0;i>arr.length;i++){
            // arr[i]   = 11110011110000
            // rightOne = 00000000010000
            if ((arr[i] & rightOne)!=0){
                onlyOne ^= arr[i];
            }
        }

        System.out.println(onlyOne+" "+(eor ^ onlyOne));


    }

    public static void main(String[] args) {

        int[] nums = {7,3,4,5,3,4,5,6};
        findNums(nums);


    }

}
