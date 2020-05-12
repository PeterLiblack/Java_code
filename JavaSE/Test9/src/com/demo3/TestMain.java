package com.demo3;

/**
 * @Author Li_ZW
 * @Date: 2020/05/02
 * @Time: 9:54
 * @Description
 * 多态
 */
class Animal {
    protected String name;
    public Animal(String name) {
        this.name = name;
        System.out.println("Animal(String)");
        eat();
    }
    public void eat() {
        System.out.println(this.name + "Animal::eat()");
    }
}

class Cat extends Animal {
    public int count = 99;
    public Cat(String name) {
        super(name); //显示调用父类的构造方法
    }
    public void eat() {
        System.out.println(this.name + "的示范法Cat::eat()");
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

public class TestMain {
    public static void main(String[] args) {
        Cat cat = new Cat("八鸽");
        cat.eat();
    }

    /**
     * 不安全的向下转型
     */
    public static void main7(String[] args) {
        Animal animal = new Cat("巴哥");
        //A instanceof B 判断A是不是B的一个实例
        if (animal instanceof Bird) {
            //向下转型
            Bird bird = (Bird)animal;
            bird.fly();
        }else {
            System.out.println("飞飞飞");
        }
    }

    /**
     * 向下转型
     * 向下转型非常不安全，很少使用
     */
    public static void main6(String[] args) {
        Animal animal = new Bird("巴哥");
        animal.eat();
        //向下转型——》父类的引用 赋值给 子类
        Bird bird = (Bird)animal;
        bird.fly();
    }

    /**
     * 多态
     *
     * 运行时绑定：
     * 父类引用 引用子类对象
     * 通过父类引用调用同名的覆盖方法
     */
    public static void main5(String[] args) {
        Animal animal = new Cat("咪咪");
        animal.eat();
    }

    public static Animal func() {
        return new Cat("咪咪");
    }

    public static void main4(String[] args) {
        Animal animal = func();
        animal.eat();
    }

    public static void func(Animal animal) {
        animal.eat();
    }

    public static void main3(String[] args) {
        Cat cat = new Cat("咪咪");
        func(cat);
    }

    //向上转型
    public static void main2(String[] args) {
        //向上转型——》父类引用 引用子类对象
        Animal animal = new Cat("咪咪");
        animal.eat();

        //animal.count;
        //error:向上转型之后，通过父类的引用
        //只能访问父类自己的方法或者属性
    }

    public static void main1(String[] args) {
        Animal animal = new Animal("豆豆");
        Cat cat = new Cat("咪咪");
    }
}
