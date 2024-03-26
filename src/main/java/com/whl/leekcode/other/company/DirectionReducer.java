package com.whl.leekcode.other.company;

import java.util.*;

/**
 * 美的1
 *
 * @author 79183
 * @date 2024/3/26 14:38
 */
public class DirectionReducer {

    public static void main(String[] args) {
        String[] directions = {"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"};
        String[] reducedDirections = dirReduc2(directions);

        System.out.println("Reduced directions:");
        System.out.println(Arrays.toString(reducedDirections));
    }

    /**
     * 方法1
     * @param directions
     * @return
     */
    public static String[] dirReduc(String[] directions) {
        Stack<String> stack = new Stack<>();

        for (String direction : directions) {
            if (!stack.isEmpty() && isOpposite(stack.peek(), direction)) {
                stack.pop();
            } else {
                stack.push(direction);
            }
        }

        return stack.toArray(new String[0]);
    }

    private static boolean isOpposite(String dir1, String dir2) {
        return ("NORTH".equals(dir1) && "SOUTH".equals(dir2)) ||
                ("SOUTH".equals(dir1) && "NORTH".equals(dir2)) ||
                ("EAST".equals(dir1) && "WEST".equals(dir2)) ||
                ("WEST".equals(dir1) && "EAST".equals(dir2));
    }


    /**
     * HashMap的方式  推荐
     * @param directions
     * @return
     */
    public static String[] dirReduc2(String[] directions) {
        // 定义相反的方向
        Map<String, String> opposites = new HashMap<>();
        opposites.put("NORTH", "SOUTH");
        opposites.put("SOUTH", "NORTH");
        opposites.put("EAST", "WEST");
        opposites.put("WEST", "EAST");

        // 使用栈来存储有效的方向
        //Stack<String> stack = new Stack<>();
        Deque<String> stack = new LinkedList<>();

        // 遍历每个方向
        for (String direction : directions) {
            // 如果栈不为空且当前方向与栈顶方向相反
            if (!stack.isEmpty() && stack.peek().equals(opposites.get(direction))) {
                // 弹出栈顶方向
                stack.pop();
            } else {
                // 否则，将当前方向入栈
                stack.push(direction);
            }
        }

        // 将栈中的方向转换为字符串数组
       /* String[] simplifiedDirections = new String[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            simplifiedDirections[i] = stack.pop();
        }*/

        /**
         * 在代码中，stack.toArray(new String[0])这行代码的作用是创建一个String类型的数组，其大小与堆栈中元素的数量相等，
         * 并将堆栈中的元素复制到这个数组中。如果堆栈为空，则创建一个长度为0的String数组。
         *
         * 传递new String[0]作为参数是一种常用的方式，因为这样可以告诉Java，我们需要一个String类型的数组，
         * 但我们并不关心数组的初始大小，Java会根据堆栈中元素的数量自动调整数组的大小。
         */
        // 将栈中的方向转换为字符串数组
        return stack.toArray(new String[0]);
    }


}
