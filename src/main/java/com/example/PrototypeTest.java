package com.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

/**
 * 原型模式
 */
public class PrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
//       假设是一个获取一个复杂对象的方法
       /* ProtoProduct protoProduct = new ProtoProduct("1","2","3","4");
        protoProduct.clone();*/
        Person zhangsan = new Person("zhangsan", 1);
        Animal animal = new Animal(zhangsan,1);
        Animal animalCopy = new Animal();
        BeanUtils.copyProperties(animal,animalCopy);
        zhangsan.setAge(13);
        System.out.println(animalCopy.getHost().getAge());

    }
}

class ProtoProduct implements Cloneable{
    private String part1;
    private String part2;
    private String part3;
    private String part4;

    public ProtoProduct(String part1, String part2, String part3, String part4) {
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
        this.part4 = part4;
    }

    @Override
    protected ProtoProduct clone() throws CloneNotSupportedException {
        return (ProtoProduct)super.clone();
    }

    public String getPart1() {
        return part1;
    }

    public void setPart1(String part1) {
        this.part1 = part1;
    }

    public String getPart2() {
        return part2;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }

    public String getPart3() {
        return part3;
    }

    public void setPart3(String part3) {
        this.part3 = part3;
    }

    public String getPart4() {
        return part4;
    }

    public void setPart4(String part4) {
        this.part4 = part4;
    }
}



@Data
@AllArgsConstructor
@NoArgsConstructor
class Person {
    String name;
    int age;
}
//测试类2
@Data
@AllArgsConstructor
@NoArgsConstructor
class Animal {
    Person host;//主人
    int age;//年纪
}

