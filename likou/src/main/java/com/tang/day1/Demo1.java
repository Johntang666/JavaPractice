package com.tang.day1;

import java.util.Arrays;
import java.util.HashMap;

public class Demo1 {
    public static void main(String[] args) {
        int nums[]={2,7,11,15};
        isMerge(nums,18);

    }

    public static void isMerge(int[] nums,int target){
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        int need,i;
        int[] arr=new int[2];
        for(i=0;i<nums.length;i++){
            need=target-nums[i];
            if(hashMap.containsKey(need)){
                arr[0]=i;
                arr[1]=hashMap.get(need);
            }
            hashMap.put(nums[i],i);
        }
        Arrays.stream(arr)
                .forEach(System.out::println);
    }
}
