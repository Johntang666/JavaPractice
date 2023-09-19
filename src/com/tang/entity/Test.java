package com.tang.entity;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        ClassRoom classRoom = new ClassRoom();
        classRoom.setName("一班");
        classRoom.setAddress("图书馆一楼");
        classRoom.setStudentList(new ArrayList<Student>(Arrays.asList(
                new Student("唐","142","男"),
                new Student("奖","123","女")
        )
        ));

        ClassRoom classRoom1 = new ClassRoom();
        classRoom1= (ClassRoom) classRoom.clone();
        System.out.println(classRoom1);
        String originalString = "软件研发中心在哪个地方";
        String substringToRemove = "软件";
        String modifiedString = originalString.replace(substringToRemove, "");
        System.out.println(modifiedString);
    }
}
