package com.whl.leekcode.easy;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 *  有效的括号      7.14写成功(!! 为写的时候有问题)
 *  给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * @author liaowenhui
 * @date 2022/2/9 16:32
 */
public class LeekCode20 {
    public static void main(String[] args) {
        //false
        String s = "([)]";
        System.out.println(isValid(s));
        //true
        String s1 = "()[]{}";
        System.out.println(isValid(s1));
        String s4 = "([]]";
        System.out.println(isValid(s4));

        System.out.println("-----------------------------------------------");

        //false
        String s2 = "([])";
        System.out.println(isValid2(s2));
        //true
        String s3 = "()[]{}";
        System.out.println(isValid2(s3));
    }

    /**
     * 方法一
     * 时间复杂度不好判断，是O(n^2/2)，比起用stack的话，时间复杂度要差点
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        int length;
        do {
            //!! 注意这行不在do外面
            length = s.length();
            s = s.replace("()", "")
                    .replace("{}", "")
                    .replace("[]", "");
        } while (length != s.length());
        return s.length() == 0;
    }

   /* public static boolean testIsValid(String s) {
        int n = s.length();
        do{
            s = s.replace("()","")
                    .replace("[]","")
                    .replace("{}","");

        }while (n != s.length());
        return
    }*/


    /**
     * 方法2
     * 使用栈解决
     * 时间复杂度：O(n)，其中 n是字符串 sss 的长度。
     * @param s
     * @return
     */
    public static boolean isValid2(String s) {
        int n = s.length();
        //有效字符串的长度一定为偶数，因此如果字符串的长度为奇数，我们可以直接返回 False，省去后续的遍历判断过程
        if (n % 2 == 1) {
            return false;
        }
        //为了快速判断括号的类型，我们可以使用哈希表存储每一种括号。哈希表的键为右括号，值为相同类型的左括号。
        //!!注意怎么初始化的
        Map<Character, Character> pairs = new HashMap<Character, Character>(6) {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        //java把栈封装在了linkedlist中的deque接口里面 ！！
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            //如果是右括号，如果栈为空(说明没有对应的左括号)或者如果栈顶的左括号和对应的左括号不同的话，不符
            if (pairs.containsKey(ch)) {
                //peek():查看该堆栈顶部的对象，而不将其从堆栈中删除  ！！
                //!! 别忘了判断stack.isEmpty()
                if (stack.isEmpty() || !stack.peek().equals(pairs.get(ch))) {
                    return false;
                }
                //栈顶的左括号和对应的左括号相同，出栈
                //pop():移除该堆栈顶部的对象，并将该对象作为该函数的值返回 ！！
                stack.pop();
                //如果是左括号，入栈
            } else {
                //push() ：在堆栈的顶部加入一个元素。
                stack.push(ch);
            }
        }
        //  在遍历结束后，如果栈中没有左括号，说明我们将字符串 ss 中的所有左括号闭合  ！！
        // !!注意不是直接返回ture
        return stack.isEmpty();
    }

    public static boolean testIsValid2(String s) {
        int n = s.length();
        if (n % 2 == 1){
            return false;
        }
        HashMap<Character, Character> hashMap = new HashMap<Character, Character>() {
            {
                put(')','(');
                put(']','[');
                put('}','{');
            }
        };

        Deque<Character> stack  = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(0);
            if (hashMap.containsKey(c) ){
                //!!没有
                if (stack.peek().equals(hashMap.get(c))){
                    stack.pop();
                }
            }else {
                stack.push(c);
            }
        }

        return true;

    }

}
