package com.whl.leekcode.easy;

import sun.misc.PostVMInitHook;

import java.util.Arrays;

/**
 * 剑指 Offer II 003. 前 n 个数字二进制中 1 的个数
 * @author liaowenhui
 * @date 2022/2/9 15:21
 */
public class Offer003 {

    public static void main(String[] args) {
        int n = 8;
        int[] ints = countBits(n);
        int[] ints1 = countBits2(n);
        System.out.println("int值为：" + Arrays.toString(ints));
        System.out.println("int1值为：" + Arrays.toString(ints1));

    }

    public static int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            bits[i] = countOnes(i);
        }
        return bits;
    }

    /**
     * 利用 Brian Kernighan 算法计算一个整数二进制中的1
     * eg：countOnes(3)=2
     *  （1）3&2 即0011&0010 = 0010 =2
     *  （2）2&1 即0010&0001 = 0
     *
     */
    public static int countOnes(int x) {
        int ones = 0;
        while (x > 0) {
            //x=x&(x-1)
            x &= (x - 1);
            ones++;
        }
        return ones;
    }

    /**
     * 方法2 Integer.bitCount(i)
     * 返回指定int值的二进制补码表示形式中1位的个数
     * @param n
     * @return
     */
    public static int[] countBits2(int n) {
        int[] answer = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            answer[i] = Integer.bitCount(i);
        }
        return answer;
    }

}
