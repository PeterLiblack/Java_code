/**
 * @Author Li_ZW
 * @Date: 2020/05/26
 * @Time: 15:39
 * @Description
 * 内部类
 */

class Animal {
    public void func() {
        System.out.println("Animal::func()");
    }
}

public class TestDemo4 {
    public static void main(String[] args) {
        new Animal(){
            @Override
            public void func() {
                System.out.println("重写了这个方法！");
            }
        }.func();
    }
}
