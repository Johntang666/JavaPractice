package com.tang.day6;

/**
 * @author tangzhipeng
 * @project Java
 * @description: 零钱规划
 * @date 2023/9/20 14:40
 */
public class Demo3 {
    public static void main(String[] args) {
        System.out.println(changePlanning(new int[]{1, 2, 5},10));
    }

    /**
     * 暴力递归解法
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


}
