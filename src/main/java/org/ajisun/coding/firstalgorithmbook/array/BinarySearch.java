package org.ajisun.coding.firstalgorithmbook.array;

/**
 * 二分查找利用已排好序的数组，每一次查找都可以将查找范围减半。查找范围内只剩一个数据时查找结束。
 * 数据量为 n 的数组，将其长度减半 log2n 次后，其中便只剩一个数据了。也就是说，
 * 在二分查找中重复执行“将目标数据和数组中间的数据进行比较后将查找范围减半”的操作 log2n 次后，
 * 就能找到目标数据（若没找到则可以得出数据不存在的结论），因此它的时间复杂度为 O(logn)。
 */

import java.util.Arrays;

/**
 * @Copyright (c) 2021. ajisun. All right reserved.
 * @ProjectName: ajisun-leetcode
 * @PackageName: org.ajisun.coding.firstalgorithmbook.array
 * @Date: 2021/6/7
 * @author: ajisun
 * @Email: ajisun
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = new int[]{5, 3, 8, 4, 2, 1, 9, 7, 6, 500, 100, 300, 200, 400};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        int key = 100;
        int left = 0;
        int right = arr.length-1;
        int index = recursionBinarySearch(arr,key,left,right);
        System.out.println(index);

    }


    public static  int recursionBinarySearch(int[] arr,int key,int left,int right){
        int index = (left+right)/2;
        if (arr[index] ==key){
            return index;
        }else if (arr[index] > key){
            right = index;
            return recursionBinarySearch(arr,key,left,right);
        }else {
            left = index;
            return recursionBinarySearch(arr,key,left,right);
        }
    }

}
