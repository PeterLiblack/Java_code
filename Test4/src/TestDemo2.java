/**
 * @Author Li_ZW
 * @Date: 2020/04/20
 * @Time: 19:02
 * @Description
 * 时间复杂度和空间复杂度
 * 1.算法效率
 * 算法效率分析分为两种：第一种是时间效率，第二种是空间效率。时间效率被称为时间复杂度，而空间效率被
 * 称作空间复杂度。
 * 2.时间复杂度
 * 3.空间复杂度
 */

public class TestDemo2 {
    //时间复杂度
    //一个算法所花费的时间与其中语句的执行次数成正比例，算法中的基本操作的执行次数，为算法的时间复杂度。

    //大O的渐进表示法
    //1、用常数1取代运行时间中的所有加法常数。
    //2、在修改后的运行次数函数中，只保留最高阶项。
    //3、如果最高阶项存在且不是1，则去除与这个项目相乘的常数。得到的结果就是大O阶。

    // 计算func1的时间复杂度？
    static void func1(int N){
        int count = 0;
        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < N ; j++) {
                count++;
            }
        }
        for (int k = 0; k < 2 * N ; k++) {
            count++;
        }
        int M = 10;
        while ((M--) > 0) {
            count++;
        }
        System.out.println(count);
    }
    //通过推导大O阶方法知道，时间复杂度为 O(N^2)

    // 计算func2的时间复杂度？
    void func2(int N) {
        int count = 0;
        for (int k = 0; k < 2 * N ; k++) {
            count++;
        }
        int M = 10;
        while ((M--) > 0) {
            count++;
        }
        System.out.println(count);
    }
    //func2基本操作执行了2N+10次，通过推导大O阶方法知道，时间复杂度为 O(N)

    // 计算func3的时间复杂度？
    void func3(int N, int M) {
        int count = 0;
        for (int k = 0; k < M; k++) {
            count++;
        }
        for (int k = 0; k < N ; k++) {
            count++;
        }
        System.out.println(count);
    }
    //时间复杂度为 O(N+M)

    // 计算func4的时间复杂度？
    void func4(int N) {
        int count = 0;
        for (int k = 0; k < 100; k++) {
            count++;
        }
        System.out.println(count);
    }
    //基本操作执行了100次，通过推导大O阶方法，时间复杂度为 O(1)

    // 计算bubbleSort的时间复杂度？
    void bubbleSort(int[] array) { 
        for (int end = array.length; end > 0; end--) { 
            boolean sorted = true;
            for (int i = 1; i < end; i++) { 
                if (array[i - 1] > array[i]) {
                    Swap(array, i - 1, i);
                    sorted = false; 
                } 
            }
            if (sorted == true) { 
                break; 
            } 
        } 
    }
    //基本操作执行最好N次，最坏执行了(N*(N-1))/2次，通过推导大O阶方法+时间复杂度一般看最坏，
    //时间复杂度为 O(N^2)

    // 计算binarySearch的时间复杂度？
    int binarySearch(int[] array, int value) {
        int begin = 0;
        int end = array.length - 1;
        while (begin <= end) {
            int mid = begin + ((end-begin) / 2);
            if (array[mid] < value)
                begin = mid + 1;
            else if (array[mid] > value)
                end = mid - 1;
            else
                return mid;
        }
        return -1;
    }
    //基本操作执行最好1次，最坏O(logN)次，时间复杂度为 O(logN)
    // ps：logN在算法分析中表示是底数为2，对数为N。
    // 有些地方会写成lgN。

    // 计算阶乘递归factorial的时间复杂度？
    long factorial(int N) {
        return N < 2 ? N : factorial(N-1) * N;
    }
    //基本操作递归了N次，时间复杂度为O(N)。

    // 计算斐波那契递归fibonacci的时间复杂度？
    int fibonacci(int N) {
        return N < 2 ? N : fibonacci(N-1)+fibonacci(N-2);
    }
    //基本操作递归了2^N次，时间复杂度为O(2^N)。

    //空间复杂度
    //空间复杂度是对一个算法在运行过程中临时占用存储空间大小的量度 ，也使用大O渐进表示法。
    // 计算bubbleSort的空间复杂度？
    void bubbleSort(int[] array) {
        for (int end = array.length; end > 0; end--) {
            boolean sorted = true;
            for (int i = 1; i < end; i++) {
                if (array[i - 1] > array[i]) {
                    Swap(array, i - 1, i);
                    sorted = false;
                }
            }
            if (sorted == true) {
                break;
            }
        }
    }
    //使用了常数个额外空间，所以空间复杂度为 O(1)

    // 计算fibonacci的空间复杂度？
    int[] fibonacci(int n) {
        long[] fibArray = new long[n + 1];
        fibArray[0] = 0;
        fibArray[1] = 1;
        for (int i = 2; i <= n ; i++) {
            fibArray[i] = fibArray[i - 1] + fibArray [i - 2];
        }
        return fibArray;
    }
    //动态开辟了N个空间，空间复杂度为 O(N)

    // 计算阶乘递归Factorial的时间复杂度？
    long factorial(int N) {
        return N < 2 ? N : factorial(N-1)*N;
    }
    //递归调用了N次，开辟了N个栈帧，每个栈帧使用了常数个空间。空间复杂度为O(N)
}
