package com.example.simple;

public class Singleton {
    public Singleton() {
    }
    /*private static Singleton ins = new Singleton()

    public static Singleton getIns() {
        return ins;
    }*/

    private static class Hold{
         static Singleton ins = new Singleton();
    }

    public static Singleton getInstance() {
        return Hold.ins;
    }


}
