package com.tang.day6;

import java.util.Arrays;

/**
 * @author tangzhipeng
 * @project Java
 * @description: 零钱规划
 * @date 2023/9/20 14:40
 */
public class Demo3 {
    public static void main(String[] args) {
        System.out.println(changeUpToDown(new int[]{1, 2, 5}, 10));
    }

    /**
     * 暴力递归解法
     *
     * @param arr
     * @param amount
     * @return
     */
    public static int changePlanning(int[] arr, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        int res = Integer.MAX_VALUE;
        for (int coin : arr) {
            int subProblem = changePlanning(arr, amount - coin);
            if (subProblem == -1) {
                continue;
            }
            res = Math.min(res, subProblem + 1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    static int[] memo;

    /**
     * 自顶向下
     *
     * @param arr
     * @param amount
     * @return
     */
    public static int changeUpToDown(int[] arr, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -666);
        return dp(arr, amount);
    }

    public static int dp(int[] arr, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (memo[amount] != -666) {
            return memo[amount];
        }
        int res = Integer.MAX_VALUE;
        for (int coin : arr) {
            int subProblem = dp(arr, amount - coin);
            if (subProblem == -1) {
                continue;
            }
            res = Math.min(subProblem + 1, res);
        }
        memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return memo[amount];
    }

}
