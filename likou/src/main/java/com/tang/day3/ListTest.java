package com.tang.day3;

import java.util.ArrayList;
import java.util.Arrays;

public class ListTest {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        String[] s={"aa","bb","cc","dd"};
        strings.addAll(Arrays.asList(s));
        for(int i=0;i<strings.size();i++){
                strings.remove(i);
        }
        strings.forEach(System.out::println);

    }

}
