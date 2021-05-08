package org.ajisun.coding.leetcode.StringCode;

/**
 * @Copyright (c) 2021. ajisun. All right reserved.
 * @ProjectName: ajisun-leetcode
 * @PackageName: org.ajisun.coding.leetcode.StringCode
 * @Date: 2021/1/14
 * @author: ajisun
 * @Email: sunj.guang@foxmail.com
 */
public class IsPalindrome {


    public static boolean ispalindrome(String s) {

        StringBuffer stringBuffer = new StringBuffer();
        char[] aa = s.toCharArray();
        String[] ddd;
        for (char a : aa) {
            if (Character.isLetterOrDigit(a)) {
                stringBuffer.append(Character.toLowerCase(a));
            }
        }

        int i = 0;
        int j = stringBuffer.length() - 1;
        while (i < j) {
            if (stringBuffer.charAt(i) != stringBuffer.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println(ispalindrome("race a car"));

    }


}
