package com.demo1;

/**
 * @Author Li_ZW
 * @Date: 2020/05/02
 * @Time: 9:52
 * @Description
 */
class Base {
    public int a;
}

class Derive extends Base {
    public int b;
}

public class TestDemo2 {
    public static void main1(String[] args) {
        Base base = new Base();
        System.out.println(base.a);
    }

    public static void main2(String[] args) {
        Derive derive = new Derive();
        derive.a = 99;
    }

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.a);
    }
}
