import java.util.Scanner;

/**
 * @Author Li_ZW
 * @Date: 2020/05/10
 * @Time: 20:00
 * @Description
 * 异常
 */

class Person implements Cloneable{
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class TestDemo {
    public static void main6(String[] args) {
        Person person = new Person();
        try {
            Person person2 = (Person)person.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }


    public static int divide(int x,int y) throws ArithmeticException{
        if(y == 0) {
            throw new ArithmeticException("y == 0");
        }
        return x/y;
    }

    /**
     * 抛出异常 :  throw   一般抛出某个你想抛出的异常(自定义的异常)
     * @param args
     */
    public static void main5(String[] args) {
        try {
            int ret = divide(20,0);
            System.out.println(ret);
        }catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("hhhh");
        }
        System.out.println("继续执行");
    }


    public static void func2() {
        int[] arr = {1, 2, 3};
        System.out.println(arr[100]);
    }


    public static void main4(String[] args) {
        try {
            func2();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        System.out.println("after try catch");
    }



    public static int func1() {
        int[] array = {1,2,3};
        try {
            System.out.println(array[4]);
            //return  1;
        }catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("捕获到了空指针异常");
            return 3;
        }finally {
            return 2;
        }
    }


    public static void main(String[] args) {
        //System.out.println(func1());

        Scanner scanner = new Scanner(System.in);

        try {
            int n = scanner.nextInt();
            System.out.println(10/n);
        }catch (ArithmeticException e) {
            e.printStackTrace();
        }finally {
            scanner.close();
        }

    }

    public static void main1(String[] args) {
        int[] array = {1,2,3};
        System.out.println(array[4]);
        System.out.println("hello");

        //Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 4
        //一旦出现异常, 程序就终止了
    }

    //使用 try catch 后的程序执行过程
    public static void main2(String[] args) {

        int[] array = {1,2,3};
        try {
            System.out.println(array[4]);
            System.out.println("不会被执行！");
        }catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("捕获到了空指针异常");
        }catch ( ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("捕获到了空数组越界异常");
        }finally {
            System.out.println("finally块的代码肯定会被执行！，" +
                    "所以经常做一些善后工作，比如关闭资源");
        }
        System.out.println("hello");

        //java.lang.ArrayIndexOutOfBoundsException: 4
        //捕获到了空数组越界异常
        //finally块的代码肯定会被执行！，所以经常做一些善后工作，比如关闭资源
        //hello

    }

    public static void main3(String[] args) {
        int[] arr = {1, 2, 3};
        try {
            System.out.println("before");
            arr = null;
            System.out.println(arr[100]);
            System.out.println("after");
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        System.out.println("after try catch");
    }
}
