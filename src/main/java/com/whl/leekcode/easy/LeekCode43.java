package com.whl.leekcode.easy;

/**
 * 字符串相乘   相加415
 * @author liaowenhui
 * @date 2022/7/11 10:34
 */
public class LeekCode43 {

    public static void main(String[] args) {
        System.out.println(multiplyTest("456","30"));
    }

    /**
     * 时间复杂度：O(mn+n^2)
     * 空间复杂度：O(m+n)
     * 被乘数在前面,乘数在后面
     * @param num1 被乘数
     * @param num2 乘数
     * @return
     */
    public static String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        String ans = "0";
        int m = num1.length() - 1, n = num2.length() - 1;
        //循环乘数num2的每一位，与num1相乘
        for (int i = n; i >= 0; i--) {
            StringBuilder curr = new StringBuilder();
            //!!注意位置
            int add = 0;
            //乘数num2除了最低位以外，其余的每一位的运算结果都需要补0。
            for (int j = n; j > i; j--) {
                curr.append(0);
            }
            int y = num2.charAt(i) - '0';
            for (int j = m; j >= 0; j--) {
                int x = num1.charAt(j) - '0';
                int product = x * y + add;
                curr.append(product % 10);
                add = product / 10;
            }
            //理解
            //!!漏了
            if (add != 0) {
                curr.append(add % 10);
            }
            ans = addStrings(ans, curr.reverse().toString());
        }
        return ans;
    }

    public static String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuilder ans = new StringBuilder();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();
    }

    public static String multiplyTest(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int l1 = num1.length() - 1, l2 = num2.length() - 1;
        String ans = "0";
        for (int i = l2; i >= 0; i--) {
            StringBuilder stringBuilder = new StringBuilder();
            //num2中除最低位外，其余都要末尾加0
            for (int j = l2; j > i; j--) {
                stringBuilder.append("0");
            }

            int x = num2.charAt(i) - '0';
            for (int j = l1;  j >= 0; j--) {
                int y = num1.charAt(j) - '0';
                int add = 0;
                int product = x * y + add;
                int yu = product % 10;
                add = product / 10;

                stringBuilder.append(yu);
            }

            //相加
            ans = addStrings(ans, stringBuilder.reverse().toString());
        }
        return ans;
    }


}
