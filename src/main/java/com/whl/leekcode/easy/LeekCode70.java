package com.whl.leekcode.easy;

/**
 * 爬楼梯
 * @author liaowenhui
 * @date 2022/7/19 10:00
 */
public class LeekCode70 {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(climbStairs(n));

        System.out.println(f(n));

    }

    /**
     * 1 2 3 5 8
     * 方法一 滚动数组思想
     * 用「滚动数组思想」把空间复杂度优化成 O(1)
     * 时间复杂度：循环执行 n 次，每次花费常数的时间代价，故渐进时间复杂度为 O(n)。
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    /**
     * 动态规划 考虑最后一步可能跨了一级台阶，也可能跨了两级台阶  转移方程: f(x)=f(x−1)+f(x−2)
     * 时间复杂度和空间复杂度都是 O(n) 的实现
     *
     * 步骤一: 定义数组元素，的含义 dp[i] 的含义为：跳上一个 i 级的台阶总共有 dp[i] 种跳法
     * 步骤二: 找出数组元素间的关系式，考虑最后一步可能跨了一级台阶，也可能跨了两级台阶。  转移方程: f(x)=f(x−1)+f(x−2)
     * 步骤三： 找出初始条件，我们是从第0级开始爬的,所以从第0级爬到第0级我们可以看作只有一种方案，即 f(0)=1；从第 0级到第 1 级也只有一种方案，即爬一级，f(1) = 1
     *
     * 注意题目中  1<= n <= 45
     * @param n
     * @return
     */
    static int f(int n){
        if(n <= 2) {
            return n;
        }
        // 先创建一个数组来保存历史数据
        int[] dp = new int[n+1];

        // 给出初始值
        dp[1] = 1;
        dp[2] = 2;
        // 通过关系式来计算出 dp[n]
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        // 把最终结果返回
        return dp[n];
    }


   /* static int fTest(int n){
        if (n<3){
            return n;
        }

        f(1) = 1;
        f(2) = 2;
        if (int i = 3,i <n ,i++){
            f(i) = f(i-1) + f(i+1);
        }


    }*/


}
