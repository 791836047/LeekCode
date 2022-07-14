package com.whl.leekcode.easy;

/**
 * YY二面
 * @author liaowenhui
 * @date 2021/11/29 10:14
 */
public class LeekCode476 {
    public static int findComplement(int num) {
        int highbit = 0;
        for (int i = 1; i <= 30; ++i) {
            //首先找到num二进制表示最高位的那个1,eg:1 << 2 = 4
            if (num >= (1 << i)) {
                highbit = i;
            } else {
                break;
            }
        }
        /**
         *  取反可以通过num 与 掩码mask 进行异或运算
         *
         * 异或运算 0⊕0=0，1⊕0=1，0⊕1=1，1⊕1=0（同为0，异为1）
         * java中异或是以二进制数据为基础进行运算的；也就是说当代码中使用到异或运算时，都会先将两个条件进行转换，转换成二进制数据后，再进行运算。
         * 运算规则：两个操作数的同位中，如果值相同(都是0或者都是1)则为0，不同(一个是0，一个是1)则为1。
         */
        int mask = highbit == 30 ? 0x7fffffff : (1 << (highbit + 1)) - 1;
        return num ^ mask;
    }

    public static void main(String[] args) {
        int complement = findComplement(5);
        System.out.println(complement);

    }
}
