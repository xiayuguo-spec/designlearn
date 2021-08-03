package com.example.simple;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 静态内部类 懒加载 调用静态类getIns方法的第一次的时候加载
 */
public class InnerSingleClass {
    public InnerSingleClass() {
    }

    private static class InnerClassHolder{
        private static InnerClassHolder ins = new InnerClassHolder();
    }

    public static InnerClassHolder getIns() {
        return InnerClassHolder.ins;
    }


}


