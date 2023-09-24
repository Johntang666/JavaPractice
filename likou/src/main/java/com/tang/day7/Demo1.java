package com.tang.day7;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author tangzhipeng
 * @project Java
 * @description:
 * @date 2023/9/21 10:43
 */
public class Demo1 {
    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeFiled = Unsafe.class.getDeclaredFields()[0];
        unsafeFiled.setAccessible(true);
        Unsafe unsafe =(Unsafe) unsafeFiled.get(null);
        //分配内存调用C++代码
        long address = unsafe.allocateMemory(4);
        unsafe.putInt(address,666666666);
        System.out.println(unsafe.getInt(address));
        unsafe.freeMemory(address);
        System.out.println(unsafe.getInt(address));

    }


}
