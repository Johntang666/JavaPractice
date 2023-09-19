package com.tang.entity;

import java.util.ArrayList;
import java.util.List;

public class ClassRoom implements Cloneable{
    private String name;
    private String address;
    private List<Student> studentList;

    public ClassRoom() {
        this.name = name;
        this.address = address;
        this.studentList = studentList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        ClassRoom classRoom = new ClassRoom();
        classRoom=(ClassRoom) super.clone();
        classRoom.setStudentList(new ArrayList<>(this.studentList));
        return classRoom;
    }

    @Override
    public String toString() {
        return "ClassRoom{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", studentList=" + studentList +
                '}';
    }
}
