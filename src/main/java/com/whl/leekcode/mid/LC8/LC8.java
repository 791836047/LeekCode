package com.whl.leekcode.mid.LC8;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 79183
 * @date 2024/7/27 13:51
 */
public class LC8 {

    public static void main(String[] args) {
        System.out.println("result:" + myAtoi(" -045"));
    }

    /**
     * 官方
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        Automaton automaton = new Automaton();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            automaton.get(str.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }

}
