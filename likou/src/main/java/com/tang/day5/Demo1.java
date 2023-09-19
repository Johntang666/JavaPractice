package com.tang.day5;

import java.util.Arrays;

/**
 * @author tangzhipeng
 * @project Java
 * @date 2023/9/19 9:23
 */
public class Demo1 {
    public static void main(String[] args) {
        /*int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxWater(arr));*/
        int[] arr={4,8,2,3,8,9,12,10,1};
        quickSort(arr,0,arr.length-1);
        Arrays.stream(arr).forEach(System.out::println);
    }


    /**
     * 只要返回最大值？
     *
     * @param arr
     * @return
     */
    public static int maxWater(int[] arr) {
        //每次就移动小的那个指针
        int left = 0, right = arr.length - 1;
        int maxValue = 0;
        while (left < right) {
            if (arr[left] < arr[right]) {
                maxValue = maxValue < ((arr[left]) * (right - left)) ? ((arr[left]) * (right - left)) : maxValue;
                left++;
            } else {
                maxValue = maxValue < ((arr[right]) * (right - left)) ? ((arr[right]) * (right - left)) : maxValue;
                right--;
            }
        }
        return maxValue;
    }

    /**
     * 排序数组查找位置
     *
     * @param arr
     * @return
     */
    /*public static int[] indexSortArr(int[] arr){



        return ;
    }*/


    /**
     * 快速排序
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotPos = partition(arr,left,right);
            quickSort(arr,0,pivotPos-1);
            quickSort(arr,pivotPos+1,right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        while (left < right) {
            while (left<right&&arr[right]>=pivot){
                --right;
            }
            arr[left]=arr[right];
            while (left<right&&arr[left]<=pivot){
                ++left;
            }
            arr[right]=arr[left];
        }
        arr[left]=pivot;
        return left;
    }
}
