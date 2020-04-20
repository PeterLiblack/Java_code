public class TestDemo {

    public static void main6(String[] args) {
        //递归求 N 的阶乘
        int n = 5;
        int ret = factor(n);
        System.out.println("ret = " + ret);
    }
    public static int factor(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factor(n - 1); // factor 调用函数自身
    }

    public static void main5(String[] args) {
        //方法的重载
        int a = 10;
        int b = 20;
        int ret1 = add(a, b);
        System.out.println("ret1 = " + ret1);

        double a2 = 10.5;
        double b2 = 20.5;
        double ret2 = add(a2, b2);
        System.out.println("ret2 = " + ret2);

        double a3 = 10.5;
        double b3 = 10.5;
        double c3 = 20.5;
        double ret3 = add(a3, b3, c3);
        System.out.println("ret3 = " + ret3);
    }
        public static int add ( int x, int y) {
            return x + y;
        }
        public static double add ( double x, double y) {
            return x + y;
        }
        public static double add ( double x, double y, double z) {
            return x + y + z;
        }
     //方法的名字都叫 add. 但是有的 add 是计算 int 相加, 有的是 double 相加;
     // 有的计算两个数字相加, 有的是计算三个数字相加.
     //同一个方法名字, 提供不同版本的实现
        /*int a = 10;
        int b = 20;
        int ret = addInt(a, b);
        System.out.println("ret = " + ret);
        double a2 = 10.5;
        double b2 = 20.5;
        double ret2 = addDouble(a2, b2);
        System.out.println("ret2 = " + ret2);
    }
    public static int addInt(int x, int y) {
        return x + y;
    }
    public static double addDouble(double x, double y) {
        return x + y;
    }*/

    public static void main4(String[] args) {
        //实参和形参的关系
        //代码示例: 交换两个整型变量
        int a = 10;
        int b = 20;
        swap(a, b);
        System.out.println("a = " + a + " b = " + b);
    }
    public static void swap(int x, int y) {
        int tmp = x;
        x = y;
        y = tmp;
        //原因分析
        //刚才的代码, 没有完成数据的交换.
        //对于基础类型来说, 形参相当于实参的拷贝. 即 传值调用

        //解决办法: 传引用类型参数
        int[] arr = {10, 20};
        swap(arr);
        System.out.println("a = " + arr[0] + " b = " + arr[1]);
    }
    public static void swap(int[] arr) {
        int tmp = arr[0];
        arr[0] = arr[1];
        arr[1] = tmp;
    }

    public static void main3(String[] args) {
        //计算1！+2！+3！+4！+5！
        int sum = 0;
        for (int i = 1; i <= 5; i++) {
            sum += factor1(i);
        }
        System.out.println("sum = " + sum);
    }
    public static int factor1(int n) {
        System.out.println("计算 n 的阶乘中! n = " + n);
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    public static void main2(String[] args) {
        //方法的调用
        int a = 10;
        int b = 20;
        System.out.println("第一次调用方法之前");
        int ret = add1(a, b);
        System.out.println("第一次调用方法之后");
        System.out.println("ret = " + ret);
        System.out.println("第二次调用方法之前");
        ret = add1(30, 50);
        System.out.println("第二次调用方法之后");
        System.out.println("ret = " + ret);
    }
    public static int add1(int x, int y) {
        System.out.println("调用方法中 x = " + x + " y = " + y);
        return x + y;
    }

    public static void main1(String[] args) {
       // 实现一个方法实现两个整数相加
        int a = 10;
        int b = 20;
        // 方法的调用
        int ret = add2(a, b);
        System.out.println("ret = " + ret);
    }
    // 方法的定义
    public static int add2(int x, int y) {
        return x + y;
    }
}
