package com.whl.leekcode.easy.offer58;/**
 * @author liaowenhui
 * @date 2022/9/23 13:51
 */

/**
 * Offer 58 - I. 翻转单词顺序
 * @author liaowenhui
 * @date 2022/9/23 13:51
 */
public class Offer58Ⅰ {

    public static void main(String[] args) {
        System.out.println("翻转后：" + reverseWords(" I am  a student.  "));

    }

    /**
     * 方法一 分割 + 倒序
     * 时间复杂度 O(N)：
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        // 删除首尾空格，分割字符串
        String[] strs = s.trim().split(" ");
        StringBuilder res = new StringBuilder();
        // 倒序遍历单词列表
        for(int i = strs.length - 1; i >= 0; i--) {
            // 遇到空单词则跳过，去掉am和a中间分割后的空格
            if(strs[i].equals("")) {
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
     * 空间复杂度 O(N) ： 新建的 StringBuilder(Java) 中的字符串总长度≤N ，占用 O(N) 大小的额外空间。。
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        // 删除首尾空格
        s = s.trim();
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while(i >= 0) {
            // 搜索首个空格
            while(i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            // 添加单词
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


}
