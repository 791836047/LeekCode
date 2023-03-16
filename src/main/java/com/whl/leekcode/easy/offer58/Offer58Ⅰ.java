package com.whl.leekcode.easy.offer58;/**
 * @author liaowenhui
 * @date 2022/9/23 13:51
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Offer 58 - I. 翻转单词顺序   字节
 * 面试用方法一二
 * @author liaowenhui
 * @date 2022/9/23 13:51
 */
public class Offer58Ⅰ {

    public static void main(String[] args) {
        System.out.println("翻转后：" + reverseWords2("  I am  a student.  "));

    }

    /**
     * 方法一 分割 + 倒序
     * 时间复杂度 O(N)：  一个简单的 for 循环，时间复杂度是 O(n)
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        // 删除首尾空格，分割字符串
        String[] strs = s.trim().split(" ");
        StringBuilder res = new StringBuilder();
        // 倒序遍历单词列表
        //!注意是lengh不是size，且不用()，数组是长度，集合元素个数
        for(int i = strs.length - 1; i >= 0; i--) {
            // 遇到空单词则跳过，去掉am和a中间分割后的空格
            //!注意equals中的s不要忘了
            if("".equals(strs[i])) {
                continue;
            }
            // 将单词拼接至 StringBuilder
            res.append(strs[i] + " ");
        }
        // 转化为字符串，删除尾部空格(I后的空格)，并返回
        return res.toString().trim();
    }

    /**
     * 方法二：双指针
     * 时间复杂度 O(N) ： 其中 N为字符串 s 的长度，线性遍历字符串。
     * 空间复杂度 O(N) ： 新建的 StringBuilder(Java) 中的字符串总长度≤N ，占用 O(N) 大小的额外空间。
     *
     * @param s
     * @return
     */
    public static String reverseWords2(String s) {
        // 删除首尾空格
        s = s.trim();
        // s "I am  a student."
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while(i >= 0) {
            // 搜索首个空格
            while(i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            // 添加单词 注意里面的i+1 j+1
            res.append(s.substring(i + 1, j + 1) + " ");
            // 跳过单词间空格
            while(i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            // j 指向下个单词的尾字符
            j = i;
        }
        // 转化为字符串并返回
        return res.toString().trim();
    }

    /**
     * 时间复杂度O(n)，其中n为输入字符串的长度
     * 空间复杂度也是O(n)，用来存储分割后的结果
     * @param s
     * @return
     */
    public static String reverseWords3(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        // \s : 匹配任意空白字符，包括空格、制表符、换页符等  \s+：匹配任意多个上面的字符
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }




}
