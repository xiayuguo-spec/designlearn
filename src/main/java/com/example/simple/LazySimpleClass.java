package com.example.simple;

/**
 * 懒汉模式
 */
public class LazySimpleClass {

    private static LazySimpleClass simpleClass;


    public LazySimpleClass() {

    }

    public static LazySimpleClass ins(){
        /**
         * 多线程的时候可能会出现多个实例 加锁
         */
        if (simpleClass == null){
            simpleClass = new LazySimpleClass();
        }
        return simpleClass;
    }

    /**
     * 加锁之后性能损耗  可能重排序 空指针 使用volatile
     * @return
     */
    public static LazySimpleClass ins1(){
        if (simpleClass == null){
            synchronized(LazySimpleClass.class){
                if (simpleClass == null){
                    simpleClass = new LazySimpleClass();
                    // 字节码
                    // JIT 即时编译
                    // 分配空间
                    // 初始化 -> 赋值 -> 实例化 -> 销毁
                }

            }

        }
        return simpleClass;
    }

    public void test(){
        InnerSingleClass.getIns();

    }


}
