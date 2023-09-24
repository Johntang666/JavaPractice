package com.tang.day6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tangzhipeng
 * @project Java
 * @description:
 * @date 2023/9/20 8:56
 */
public class Demo1 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(maxWater(arr));
    }

    /**
     * 接雨水
     * @param arr
     * @return
     */
    public static int maxWater(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[][] dp = new int[arr.length][2];
        int leftMax = arr[0];
        for (int i = 1; i < arr.length; i++) {
            leftMax = leftMax > arr[i] ? leftMax : arr[i];
            dp[i][0] = leftMax;
        }
        int rightMax = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            rightMax = rightMax > arr[i] ? rightMax : arr[i];
            dp[i][1] = rightMax;
        }
        int area = 0;
        for (int i = 1; i < arr.length - 2; i++) {
            int min = dp[i][0] < dp[i][1] ? dp[i][0] : dp[i][1];
            area += min - arr[i];
        }
        return area;
    }
    static List<List<Integer>> totalList=new ArrayList<List<Integer>>();
    static LinkedList stack = new LinkedList<Integer>();
    static HashSet<Integer> set = new HashSet<Integer>();

    /**
     * 全排列
     * @param arr
     * @return
     */
   /* public static List<List<Integer>> fullPermutationBacktrackingAlgorithm(int[] arr){

    }*/
}
