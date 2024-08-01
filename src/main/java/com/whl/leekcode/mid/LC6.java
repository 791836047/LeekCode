package com.whl.leekcode.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * Z 字形变换
 * https://leetcode.cn/problems/zigzag-conversion/solutions/21610/zzi-xing-bian-huan-by-jyd/
 * @author 79183
 * @date 2024/7/27 11:01
 */
public class LC6 {

    public static void main(String[] args) {
     /* P   A   H   N
        A P L S I I G
        Y   I   R
      */
        //PAHNAPLSIIGYIR
        System.out.println("自行变换后：" + convert("PAYPALISHIRING", 3));
    }

    /**
     * 按顺序遍历字符串 s ：
     *
     * (1) res[i] += c： 把每个字符 c 填入对应行 si;
     * (2) i += flag： 更新当前字符 c 对应的行索引；
     * (3) flag = - flag： 在达到 Z 字形转折点时，执行反向。
     *
     * 第一行PAHN
     * 第二行APLSIIG
     * 第三行YIR
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if(numRows < 2) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        /*int i = 0, flag = -1;
        for(char c : s.toCharArray()) {
            rows.get(i).append(c);
            if(i == 0 || i == numRows -1) {
                flag = - flag;
            }
            i += flag;
        }*/
        //写法2
        int i = 0, flag = 1; // flag 初始值改为 1
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0) {
                flag = 1; // 当到达第一行时，向下移动
            } else if (i == numRows - 1) {
                flag = -1; // 当到达最后一行时，向上移动
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }


}
