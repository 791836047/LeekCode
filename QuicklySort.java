package com.whl.leekcode.sort;

import java.util.Arrays;

/**
 * bigo   714(写成功)
 * 问题：什么是稳定排序和不稳定排序,时间复杂度问题
 * 快速排序  平均时间复杂度为O(n*logn)  不是稳定排序
 * 菜鸟教程-----https://www.runoob.com/w3cnote/quick-sort.html
 *
 * 思想----分治法
 * 1．先从数组中取出一个数作为基准值(eg:通常以数组第一个数为基准值)。
 * 2．进行分区，将比这个基准值大的数全放到它的右边，小于或等于它的数全放到它的左边。
 * 3．再对左右区间重复第二步，直到各区间只有一个数。
 * @author liaowenhui
 * @date 2021/12/22 10:47
 */
public class QuicklySort {
    public static void main(String[] args) {
        int[] s = new int[]{72, 6, 57, 88, 60, 42, 83, 6, 73, 48, 85};
        int r = s.length - 1;
        int l = 0;
        System.out.println("排序前" + Arrays.toString(s));
        quickSort(s, l, r);
        System.out.println("排序后" + Arrays.toString(s));
    }

    /**
     * 原数组72,6,57,88,60,42,83,6,73,48,85  以x=72是基准值
     * 数组下标            数组                        操作
     * i=0,j=10  (),6,57,88,60,42,83,6,73,48,85  ->  s[0]=s[9]=48,i++
     * i=1,j=9   48,6,57,88,60,42,83,6,73,(),85  ->  s[9]=s[3]=88,j--
     * i=3,j=7   48,6,57,(),60,42,83,6,73,88,85  ->  s[3]=s[7]=6,i++
     * i=4,j=7   48,6,57,6,60,42,83,(),73,88,85  ->  s[7]=s[6]=83,j--
     * i=6,j=6   48,6,57,6,60,42,(),83,73,88,85  ->  s[6]=s[i]=x
     * 第一次分区后 48,6,57,6,60,42,72,83,73,88,85
     * 循环两个区后继续分区  {48,6,57,6,60,42} {72,83,73,88,85}
     */
    static void quickSort(int[] s, int l, int r) {
        //这个if都不满足就没必要排序了
        if (l < r) {
            // x为基准值，s[l]即s[i]就是第一个坑
            int i = l, j = r, x = s[l];
            while (i < j) {
                // 当前区间从右向左(从后往前)找第一个小于x的数，来填s[i]
                // !! >==
                while (i < j && s[j] >= x) {
                    j--;
                }
                if (i < j) {
                    //!! 写错
                    // 将s[j]填到s[i]中，s[j]就形成了一个新的坑
                    // 等价于分两步s[i] = s[j];i++;
                    s[i++] = s[j];
                }

                // 从左向右找第一个大于等于x的数
                while (i < j && s[i] < x) {
                    i++;
                }
                if (i < j) {
                    // 将s[i]填到s[j]中，s[i]就形成了一个新的坑
                    // 等价于分两步s[j] = s[i];j--;
                    s[j--] = s[i];
                }
            }
            //!! 忘写
            s[i] = x;
            // 递归调用
            //!! i-1
            //这个i就是第一次分区后的i值，接下来对它的左右两边再进行排序
            quickSort(s, l, i - 1);
            quickSort(s, i + 1, r);
        }
    }
}
