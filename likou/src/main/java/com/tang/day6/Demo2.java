package com.tang.day6;

/**
 * @author tangzhipeng
 * @project Java
 * @description:
 * @date 2023/9/20 14:17
 */
public class Demo2 {
    public static void main(String[] args) {
        System.out.println(fibonacciOptimalOptimization(5));
    }

    /**
     * 斐波那契数列求解
     *
     * @param n
     * @return
     */
    public static int hibaNakiNumberSequence(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return hibaNakiNumberSequence(n - 1) + hibaNakiNumberSequence(n - 2);
        }
    }

    /**
     * 带备忘录的斐波那契数列
     *
     * @param n
     * @return
     */
    public static int hibaNakiNumberSequenceOptimize(int n) {
        int[] memo = new int[n + 1];
        return helper(memo, n);
    }

    public static int helper(int[] memo, int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }

    /**
     * 斐波那契自底向上
     *
     * @param n
     * @return
     */
    public static int hibaNakiSelfImprovement(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        //base case
        dp[0] = 0;
        dp[1] = 1;
        //状态转移
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 斐波那契数列最佳优化！
     * @param n
     * @return
     */
    public static int fibonacciOptimalOptimization(int n){
        if(n==0){
            return 0;
        }
        int pre=0,cur=1;
        int sum=0;
        for(int i=2;i<=n;i++){
            sum=pre+cur;
            pre=cur;
            cur=sum;
        }
        return sum;
    }

}
