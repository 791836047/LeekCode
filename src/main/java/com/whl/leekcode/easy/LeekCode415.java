package com.whl.leekcode.easy;

/**
 * LeekCode415  相乘43 bigo2
 * @author liaowenhui
 * @date 2022/7/11 10:22
 */
public class LeekCode415 {

    public static void main(String[] args) {
        System.out.println(addStrings("456","77"));
    }

    public static String addStrings(String num1, String num2) {
        //我们定义两个指针 i和 j 分别指向 num1和 num2​的末尾，即最低位，同时定义一个变量 add 维护当前是否有进位，然后从末尾到开头逐位相加即可。
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuilder ans = new StringBuilder();
        //注意条件中的add != 0，当最高位相加后如果有进位,那么add!=0，下一次的i和j都<0，依然要进行运算
        while (i >= 0 || j >= 0 || add != 0) {
            //“字符型减'0'可以得到整数型”,在指针当前下标处于负数的时候返回 0，等价于对位数较短的数字进行了补零操作
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            //“%”是取余
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();
    }
}
