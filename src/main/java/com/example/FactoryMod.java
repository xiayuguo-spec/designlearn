package com.example;

public class FactoryMod {
    public static void main(String[] args) {
        Application application = new Application();
        Product product = application.getObject(1);
        product.doSomething();

    }
}

interface Product {
    void doSomething();
}

//简单工厂模式（不是设计模式 是编程的一种习惯）
class SimpleFactory {
    public static Product getProduct(Integer i) {
        if (i.equals(0)) {
            return new ProductA();
        } else if (i.equals(1)) {
            return new ProductA();
        }
        return null;
    }
}

class ProductA implements Product {

    @Override
    public void doSomething() {
        System.out.println("ProductA.DoSomething excute");

        System.out.println("===============>");
    }
}


class ProductB implements Product {

    @Override
    public void doSomething() {
        System.out.println("ProductB.DoSomething excute");

        System.out.println("===============>");
    }
}

class Application {

    //    创建对应的实例
    private Product createProduct(Integer type) {
//        。。。。。doSomething

       // return new ProductA();
        return SimpleFactory.getProduct(type);
    }

    Product getObject(Integer type) {
       // ProductA productA = createProduct();

        Product product = createProduct(type);
        // 业务处理
        return product;
    }
}