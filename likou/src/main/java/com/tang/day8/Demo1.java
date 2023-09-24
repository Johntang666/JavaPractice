package com.tang.day8;

/**
 * @author tangzhipeng
 * @project Java
 * @description:
 * @date 2023/9/24 18:11
 */
public class Demo1 {
    public static void main(String[] args) {
        int[] arr={2,3,1,1,4};
        System.out.println(pumpIsTureOrFalse(arr));
    }

    /**
     * 给定一个非负整数数组
     * @param arr
     * @return
     */
    public static boolean pumpIsTureOrFalse(int[] arr){
        if(arr==null||arr.length==0){
            return false;
        }
        int max=arr[0];
        for (int i = 1;i<max&& i < arr.length; i++) {
            if(arr[i]+i>max){
                max=arr[i]+i;
            }
        }
        return max>=arr.length-1;
    }
}
