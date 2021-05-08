package org.ajisun.coding.leetcode;

/**
 * @Copyright (c) 2021. ajisun. All right reserved.
 * @ProjectName: ajisun-leetcode
 * @PackageName: org.ajisun.coding.leetcode
 * @Date: 2021/1/13
 * @author: ajisun
 * @Email: sunj.guang@foxmail.com
 */
public class SearchMatrix {


    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length-1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else {
                return true;
            }
        }

        return false;
    }



    public static void main(String[] args) {

        int[][] aa = {{-1,3}};
        System.out.println(searchMatrix(aa,3));
        int i = 4;
        System.out.println(i>>1);
        System.out.println(i<<1);
    }


}

