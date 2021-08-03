package com.example.simple;

/**
 * 懒汉模式
 */
public class SimpleClass {

    private static SimpleClass simpleClass;

    public SimpleClass() {
    }

    public static SimpleClass ins(){
        /**
         * 多线程的时候可能会出现多个实例 加锁
         */
        if (simpleClass == null){
            simpleClass = new SimpleClass();
        }
        return simpleClass;
    }

    /**
     * 加锁之后性能损耗  可能重排序 空指针 使用volatile
     * @return
     */
    public static SimpleClass ins1(){
        if (simpleClass == null){
            synchronized(SimpleClass.class){
                if (simpleClass == null){
                    simpleClass = new SimpleClass();
                    // 字节码
                    // JIT 即时编译
                    // 分配空间
                    // 初始化 -> 赋值 -> 实例化 -> 销毁
                }

            }

        }
        return simpleClass;
    }
}
