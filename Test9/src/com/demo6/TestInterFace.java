package com.demo6;

/**
 * @Author Li_ZW
 * @Date: 2020/05/02
 * @Time: 11:43
 * @Description
 * 接口（interface）
 * 1，接口当中的方法，都是抽象方法
 * 2，可以有具体实现的方法，这个方法被default修饰
 * 3，接口当中定义的成员变量，默认是常量
 * 4，接口当中的成员变量默认是 public static final
 * 成员方法是 public abstract
 * 5，接口是不可以被实例化的 Shape shape = new Shape（）
 * 6，接口和类之间的关系：implements
 * 7，为了解决Java单继承的问题，可以实现多个接口
 * 8，只要这个类实现了接口，那么就可以进行向上转型
 */

interface Shape {
    void draw();
}

class Cycle implements Shape {
    @Override
    public void draw() {
        System.out.println("画一个○");
    }
}

class React implements Shape {
    @Override
    public void draw() {
        System.out.println("画一个♦");
    }
}

public class TestInterFace {
    public static void drawMap(Shape shape) {
        shape.draw();
    }

    public static void main(String[] args) {
        Shape shape1 = new Cycle();
        Shape shape2 = new React();
        drawMap(shape1);
        drawMap(shape2);
    }
}
