package org.ajisun.coding.firstalgorithmbook.array;

/**
 * 线性查找需要从头开始不断地按顺序检查数据，因此在数据量大且目标数据靠后，
 * 或者目标数据不存在时，比较的次数就会更多，也更为耗时。若数据量为 n，线性查找的时间复杂度便为 O(n)。
 */


/**
 * @Copyright (c) 2021. ajisun. All right reserved.
 * @ProjectName: ajisun-leetcode
 * @PackageName: org.ajisun.coding.firstalgorithmbook.array
 * @Date: 2021/6/7
 * @author: ajisun
 * @Email: ajisun
 */
public class LinearArray {


    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 8, 4, 2, 1, 9, 7, 6, 500, 100, 300, 200, 400};

        int num = 100;
        int index = -1;
        for (int i=0;i<arr.length;i++){
            if (arr[i] == num){
                index = i;
                break;
            }
        }
        System.out.println(index);

    }
}
