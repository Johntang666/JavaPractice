package com.tang.day3;

import java.util.HashSet;
import java.util.Iterator;

public class Demo1 {
    public static void main(String[] args) {
        System.out.println(subString("abldefgadcfr"));
        HashSet<String> strings = new HashSet<>();
        strings.add("你好");
        strings.add("怎么样");
        Iterator<String> iterator = strings.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }





    public static int subString(String s){
        if(s.length()==0||s==null)
            return  0;
        HashSet<Character> set = new HashSet<>();
        int left=0,right=1;
        int max=1;
        char[] c=s.toCharArray();
        set.add(c[0]);
        while (right<s.length()){
            if (set.contains(c[right])){
                set.remove(c[left]);
                left++;
            }
            else{
                set.add(c[right]);
                max=right-left+1>max? right-left+1:max;
                right++;
            }
        }
        return max;
    }
}
