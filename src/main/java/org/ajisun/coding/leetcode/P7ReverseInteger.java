package org.ajisun.coding.leetcode;


//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
//
//
// 示例 1：
//
//
//输入：x = 123
//输出：321
//
//
// 示例 2：
//
//
//输入：x = -123
//输出：-321
//
//
// 示例 3：
//
//
//输入：x = 120
//输出：21
//
//
// 示例 4：
//
//
//输入：x = 0
//输出：0
//
//
//
//
// 提示：
//
//
// -231 <= x <= 231 - 1
/**
 * @Copyright (c) 2021. Hand Enterprise Solution Company. All right reserved.
 * @ProjectName: ajisun-leetcode
 * @PackageName: org.ajisun.coding.leetcode
 * @Date: 2021/5/11
 * @author: ajisun
 * @Email: jiguang.sun@hand-china.com
 */
public class P7ReverseInteger {

    public static void main(String[] args){
        Solution solution = new P7ReverseInteger().new Solution();
//        System.out.println(Integer.MAX_VALUE);
        System.out.println(solution.reverse2(847412));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {

            if (x==0 || x>Integer.MAX_VALUE || x<Integer.MIN_VALUE){
                return 0;
            }
                String s = x+"";
            boolean flag = s.contains("-");
                int i= s.length();
                StringBuilder sb = new StringBuilder("");
                for (int j=i-1;j>=0;j--){
                    char a =  s.charAt(j);
                    if (((int)a==0 && sb.equals("")) || (flag && j==0)){
                        continue;
                    }else {
                        sb.append(a);
                    }
                }

            if (flag){
                sb = new StringBuilder("-").append(sb);
            }

            try {

             return Integer.parseInt(sb.toString());
            }catch (Exception e){
                    e.printStackTrace();
                return 0;
            }finally {

            }
        }


        public int reverse1(int x){
            if (x==0 || x>Integer.MAX_VALUE || x<Integer.MIN_VALUE){
                return 0;
            }

            StringBuilder stringBuilder = new StringBuilder().append(x);
            int flag = 1;
            if (x<0){
                stringBuilder.replace(0,1,"");
                flag = -1;
            }

            try {
                return  Integer.valueOf(stringBuilder.reverse().toString())*flag;
            }catch (Exception e){
                e.printStackTrace();
                return  0;
            }

        }


        /**
         * 效率更高版本
         * @param x
         * @return
         */
        public int reverse2(int x){
            int rev = 0;
            while (x!=0){
                if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                    return 0;
                }
                int digit = x % 10;
                x /= 10;
                rev = rev * 10 + digit;
            }
            return rev;
        }

    }

}
