package com.tang.day4;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author tangzhipeng
 * @project Java
 * @date 2023/9/16 22:22
 */
public class Demo1 {
    public static void main(String[] args) {
        /*boolean a=validParentheses("(){)");
        System.out.println(a);*/
//        int[] arr={7,1,5,3,6,4};
//        maxSalary(arr);
        System.out.println(climb(3));
    }

    /**
     * @param str
     * @return
     */
    public static boolean validParentheses(String str) {
        HashMap<Character, Character> characterCharacterHashMap = new HashMap<>();
        characterCharacterHashMap.put('(', ')');
        characterCharacterHashMap.put('[', ']');
        characterCharacterHashMap.put('{', '}');
        char[] strList = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : strList) {
            if (characterCharacterHashMap.containsKey(c)) {
                stack.push(characterCharacterHashMap.get(c));
            } else {
                if (stack.size() > 0 && c == stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.size() == 0 ? true : false;
    }

    /**
     * 最大股票利润出售-》》[7,6,4,3,1]
     *
     * @param arr
     */
    public static void maxSalary(int[] arr) {
        if (arr == null || arr.length <= 1) {
            System.out.println("最大价值为0");
        }
        int min = arr[0];
        int maxValue = 0;
        for (int i = 0; i < arr.length; i++) {
            maxValue = arr[i] - min > maxValue ? arr[i] - min : maxValue;
            min = arr[i] < min ? arr[i] : min;
        }
        System.out.println("最大价值:" + maxValue);
    }

    /**
     * 爬楼梯
     *
     * @param n
     * @return
     */
    public static int climb(int n) {
        HashMap<Integer, Integer> integerHashMap = new HashMap<>();
        if (n <= 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return n;
        } else if(integerHashMap.containsKey(n)) {
            return integerHashMap.get(n);
        }else {
            int value=climb(n-1)+climb(n-2);
            integerHashMap.put(n,value);
            return value;
        }
    }
}
