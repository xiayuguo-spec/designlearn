package com.example;

public class FactoryModAbstract {
    public static void main(String[] args) {
        Application1 application = new ConCreateProductA();
        Product product = application.getObject(1);
        product.doSomething();

    }
}


class ProductA1{
    public void doSomething() {
        System.out.println("ProductA.DoSomething excute");

        System.out.println("===============>");
    }
}


class ProductB1  {
    public void doSomething() {
        System.out.println("ProductB.DoSomething excute");

        System.out.println("===============>");
    }
}

abstract class Application1 {

    //    创建对应的实例
    abstract Product createProduct();

    Product getObject(Integer type) {
       // ProductA productA = createProduct();

        Product product = createProduct();
        // 业务处理
        return product;
    }
}

class ConCreateProductA extends Application1{

    @Override
    Product createProduct() {
        return new ProductA();
    }
}


class ConCreateProductB extends Application1{

    @Override
    Product createProduct() {
        return new ProductB();
    }
}