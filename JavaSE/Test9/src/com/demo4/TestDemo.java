package com.demo4;

/**
 * @Author Li_ZW
 * @Date: 2020/05/02
 * @Time: 11:00
 * @Description
 */
class Animal {
    public String name;
    public Animal(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println(this.name + "正在吃！Animal");
    }
}

class Cat extends Animal {
    public String beard;
    public Cat(String name,String beard) {
        super(name);
        this.beard = beard;
    }

    public void eat() {
        System.out.println(this.name + "正在吃！Cat");
    }

    public void func() {
        System.out.println(this.name);
    }
}

public class TestDemo {
    public static void main(String[] args) {
        //父类引用 引用子类对象 向上转型
        Animal animal = new Cat("mm","hu");
        animal.eat();

        /*Cat cat = new Cat();
        cat.eat();*/
    }
}
