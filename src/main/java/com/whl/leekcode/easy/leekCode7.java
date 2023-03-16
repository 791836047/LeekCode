package com.whl.leekcode.easy;

/**
 * ali
 * https://leetcode.cn/problems/reverse-integer/solution/zheng-shu-fan-zhuan-by-leetcode-solution-bccn/
 * @author liaowenhui
 * @date 2022/7/13 11:15
 */
public class leekCode7 {

    public static void main(String[] args) {
        int x = -123;
        System.out.println(testReverse(x));
    }

    public static int reverse(int x) {
        //记rev为翻转后的数字
        int rev = 0;
        //!!注意是while不是if
        while (x != 0) {
            //以下判断是通过推到公式得出
            //!!注意是拿rev判断不是x来判断
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }

    /**
     * 练习
     * @param x
     * @return
     */
    public static int testReverse(int x) {
        if (x < Integer.MIN_VALUE/10 || x > Integer.MAX_VALUE/10){
            return 0;
        }

        int rev = 0;
        while (x >0 ){
            int temp = x % 10;
            x = x /10;
            rev = rev * 10 + temp;
        }
        return rev;
    }



}
