/**
 * @Author Li_ZW
 * @Date: 2020/05/31
 * @Time: 20:50
 * @Description
 */

//无返回值无参数
@FunctionalInterface
interface NoParameterNoReturn {
    void test();
}

//无返回值一个参数
@FunctionalInterface
interface OneParameterNoReturn {
    void test(int a);
}

//无返回值多个参数
@FunctionalInterface
interface MoreParameterNoReturn {
    void test(int a,int b);
}

//有返回值无参数
@FunctionalInterface
interface NoParameterReturn {
    int test();
}

//有返回值一个参数
@FunctionalInterface
interface OneParameterReturn {
    int test(int a);
}

//有返回值多参数
@FunctionalInterface
interface MoreParameterReturn {
    int test(int a,int b);
}

class Test {
    public void func(){
        System.out.println("func()");
    }
}

public class TestDemo2 {

    public static void main(String[] args) {
        final int a = 99;
        NoParameterNoReturn noParameterNoReturn = ()->{
            System.out.println("无参数无返回值");
            System.out.println(a);
        };
    }

    public static void main3(String[] args) {
        final int a = 100;
        new TestDemo3(){
            @Override
            public void func() {
                //a = 99;
                System.out.println("重写function方法！！！");
                System.out.println("我是捕获到变量 a == "+a
                        +" 我是一个常量，或者是一个没有改变过值的变量！");
            }
        };
    }


    public static void main2(String[] args) {
        NoParameterReturn noParameterReturn = ()->{
            return 10;
        };
        System.out.println(noParameterReturn.test());

        OneParameterReturn oneParameterReturn = (a)->{
            return a;
        };

        OneParameterReturn oneParameterReturn2 = a -> a;


        System.out.println(oneParameterReturn2.test(100));

        MoreParameterReturn moreParameterReturn = (a, b) ->  a+b;
        System.out.println(moreParameterReturn.test(100,200));

    }

    public static void main1(String[] args) {
        NoParameterNoReturn noParameterNoReturn = ()->{
            System.out.println("无参数无返回值");
        };

        NoParameterNoReturn noParameterNoReturn2 = () -> System.out.println("无参数无返回值");

        noParameterNoReturn.test();

        OneParameterNoReturn oneParameterNoReturn =  a -> System.out.println(a);

        oneParameterNoReturn.test(10);
        MoreParameterNoReturn moreParameterNoReturn = (a,b) -> System.out.println(a+" "+b);

        moreParameterNoReturn.test(10,20);
    }
}
