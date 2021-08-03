package com.example.simple;

public class HungrySimpleClass {
    private static HungrySimpleClass ins = new HungrySimpleClass();

    public HungrySimpleClass() {
    }

    public static HungrySimpleClass getIns() {
        return ins;
    }
}
