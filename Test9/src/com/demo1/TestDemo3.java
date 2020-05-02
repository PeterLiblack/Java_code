package com.demo1;

/**
 * @Author Li_ZW
 * @Date: 2020/05/02
 * @Time: 9:53
 * @Description
 * 包访问权限
 */
class Test {
    int a;
    //默认权限——》包访问权限——》只能在同一个包进行访问
}

public class TestDemo3 {
    int b;

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.a);
    }
}
