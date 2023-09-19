package com.tang.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tangzhipeng
 * @project Java
 * @date 2023/9/19 11:23
 */
public class Demo2 {
    public static void main(String[] args) {
        /*List<String> number = number("23");
        number.stream().forEach(System.out::println);*/
        int[] arr={-1, 0, 1, 2, -1, -4};

        List<List<Integer>> lists = threeSum(arr);
        lists.stream().forEach(System.out::println);
    }

    /**
     * 电话字母组合
     *
     * @param number
     * @return
     */
    public static List<String> number(String number) {
        ArrayList<String> strings = new ArrayList<>();
        if (number == null || number.length() == 0) {
            return strings;
        }
        LinkedList<String> queue = new LinkedList<>();
        queue.add("");
        for (int i = 0; i < number.length(); i++) {
            String[] array = convert(number.charAt(i));
            while (queue.size() > 0 && queue.getFirst().length() <= 1) {
                String firstValue = queue.removeFirst();
                for (int j = 0; j < array.length; j++) {
                    String temp = firstValue + array[j];
                    queue.add(temp);

                }
            }
        }
        return queue;
    }

    public static String[] convert(Character character) {
        String[] list = new String[4];
        if (character == '2') {
            list = new String[]{"a", "b", "c"};
        }
        if (character == '3') {
            list = new String[]{"d", "e", "f"};
        }
        if (character == '4') {
            list = new String[]{"g", "h", "i"};
        }
        if (character == '5') {
            list = new String[]{"j", "k", "l"};
        }
        if (character == '6') {
            list = new String[]{"m", "n", "o"};
        }
        if (character == '7') {
            list = new String[]{"p", "q", "r", "s"};
        }
        if (character == '8') {
            list = new String[]{"t", "u", "v"};
        }
        if (character == '9') {
            list = new String[]{"w", "x", "y", "z"};
        }
        return list;
    }

    /**
     * 三数之和为0：关键就是避免提交重复的数进去，如何实现？利用
     *
     * @param arr
     * @param target
     * @return
     */
    static List<List<Integer>> totalList = new ArrayList<>();

    public static List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (i >= 1 && arr[i] == arr[i - 1]) {
                continue;
            }
            int target = 0 - arr[i];
            twoSum(arr, i + 1, target);
        }

        return totalList;
    }

    public static void twoSum(int[] nums, int start, int target) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (i > start && nums[i] == nums[i - 1]){
                i++;
                continue;
            } else if (sum == target) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(0-target);
                list.add(nums[i]);
                list.add(nums[j]);
                totalList.add(list);
                i++;
                j--;
            } else if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            }
        }
    }

    /**
     * 接最大雨水
     * @param arr
     * @return
     */
    public static int maxAcceptWater(int[] arr){


        return 1;
    }
}
