package org.ajisun.coding.firstalgorithmbook.sort;


/**
 * @Copyright (c) 2021. ajisun. All right reserved.
 * @ProjectName: ajisun-leetcode
 * @PackageName: org.ajisun.coding.firstalgorithmbook.sort
 * @Date: 2021/5/30
 * @author: ajisun
 * @Email: ajisun
 */
public class Heapsort {

    public static void main(String[] args) {

        int m = 6;

        System.out.println(Math.pow(6, 3));
        System.out.println(m<<3);


    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 1<<30) ? 1<<30 : n + 1;
    }
}
