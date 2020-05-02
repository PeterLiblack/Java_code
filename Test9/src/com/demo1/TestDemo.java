package com.demo1;

/**
 * @Author Li_ZW
 * @Date: 2020/05/02
 * @Time: 9:52
 * @Description
 * 继承和多继承
 */
class Animal {
    protected String name;
    public Animal(String name) {
        this.name = name;

        System.out.println("Animal(String)");
    }
    public void eat() {
        System.out.println(this.name + "Animal::eat()");
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name); //显示调用父类的构造方法

        System.out.println("Cat(String)");
    }
}

class ChineseGardenCat extends Cat {
    public ChineseGardenCat(String name) {
        super(name);
    }
}

class OrangeCat extends ChineseGardenCat {
    public OrangeCat(String name) {
        super(name);
    }
}

class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }
    public void fly() {
        System.out.println(this.name + "Bird::fly()");
    }
}

public class TestDemo {

    public static void main1(String[] args) {
        ChineseGardenCat chineseGardenCat = new ChineseGardenCat("哈哈");
        chineseGardenCat.eat();
    }

    public static void main(String[] args) {
        Cat cat = new Cat("咪咪");
        cat.eat(); //可以访问自己的
        Bird bird = new Bird("八鸽");
        bird.fly(); //可以访问自己的
        bird.eat(); //可以访问父类的
    }
}
