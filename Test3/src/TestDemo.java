/**
 * @Author Li_ZW
 * @Date: 2020/04/20
 * @Time: 9:01
 * @Description
 * 数组的定义与使用
 *
 */
import java.util.Arrays;

public class TestDemo {
    //二维数组
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                System.out.printf("%d\t", arr[row][col]);
            }
            System.out.println("");
        }
    }

    public static void main9(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        reverse(arr);
        System.out.println(Arrays.toString(arr));

        transform(arr);
        System.out.println(Arrays.toString(arr));
    }
    //给定一个数组, 将里面的元素逆序排列
    public static void reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }

    public static void transform(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            // 该循环结束, left 就指向了一个奇数
            while (left < right && arr[left] % 2 == 0) {
                left++;
            }
            // 该循环结束, right 就指向了一个偶数
            while (left < right && arr[right] % 2 != 0) {
                right--;
            }
            // 交换两个位置的元素
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
        }
    }

    public static void main8(String[] args) {
        int[] arr = {1,9,3,10,5,7};
        System.out.println(isSorted(arr));

        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

        //冒泡排序性能较低. Java 中内置了更高效的排序算法
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    //给定一个整型数组, 判断是否该数组是有序的(升序)
    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }return true;
    }
    //冒泡排序
    public static void bubbleSort(int[] arr) {
        // [0, bound) 构成了一个前闭后开区间, 表示已排序区间
        // [bound, length) 构成了一个前闭后开区间, 表示待排序区间
        // 每循环一次, 就找到一个合适大小的元素, 已排序区间就增大1.
        for (int bound = 0; bound < arr.length; bound++) {
            for (int cur = arr.length - 1; cur > bound; cur--) {
                if (arr[cur - 1] > arr[cur]) {
                    int tmp = arr[cur - 1];
                    arr[cur - 1] = arr[cur];
                    arr[cur] = tmp;
                }
            }
        }  // end for
    } // end bubbleSort


    public static void main7(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(max(arr));
        System.out.println(avg(arr));
        System.out.println(find(arr, 6));
        System.out.println(binarySearch(arr, 6));
    }
    //给定一个整型数组, 找到其中的最大元素 (找最小元素同理)
    public static int max(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    //给定一个整型数组, 求平均值
    public static double avg(int[] arr) {
        int sum = 0; for (int x : arr) {
            sum += x;
        }
        return (double)sum / (double)arr.length;
    }
    //给定一个数组, 再给定一个元素, 找出该元素在数组中的位置.
    public static int find(int[] arr, int toFind) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == toFind) {
                return i;
            }
        }
        return -1; // 表示没有找到
    }
    //针对有序数组, 可以使用更高效的二分查找.
    public static int binarySearch(int[] arr, int toFind) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (toFind < arr[mid]) {
                // 去左侧区间找
                right = mid - 1;
            } else if (toFind > arr[mid]) {
                // 去右侧区间找
                left = mid + 1;
            } else {
                // 相等, 说明找到了
                return mid;
            }
        }
        // 循环结束, 说明没找到
        return -1;
    }

    public static void main6(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int[] newArr = Arrays.copyOf(arr, arr.length);
        System.out.println("newArr: " + Arrays.toString(newArr));

        arr[0] = 10;
        System.out.println("arr: " + Arrays.toString(arr));
        System.out.println("newArr: " + Arrays.toString(newArr));

        // 拷贝某个范围.
        int[] newArr2 = Arrays.copyOfRange(arr, 2, 4);
        System.out.println("newArr2: " + Arrays.toString(newArr2));
    }
    //实现自己版本的拷贝数组
    public static int[] copyOf(int[] arr) {
        int[] ret = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ret[i] = arr[i];
        }
        return ret;
    }
    public static void main5(String[] args) {
        //实现一个自己版本的数组转字符串
        int[] arr = {1,2,3,4,5,6};
        System.out.println(toString(arr));
    }
    public static String toString(int[] arr) {
        String ret = "[";
        for (int i = 0; i < arr.length; i++) {
            // 借助 String += 进行拼接字符串
            ret += arr[i];
            // 除了最后一个元素之外, 其他元素后面都要加上 ", "
            if (i != arr.length - 1) {
                ret += ", ";
            }
        }
        ret += "]";
        return ret;
    }

    public static void main4(String[] args) {
        //数组转字符串
        int[] arr = {1,2,3,4,5,6};
        String newArr = Arrays.toString(arr);
        System.out.println(newArr);
    }
    // 数组作为方法的返回值
    public static void main3(String[] args) {
        //写一个方法, 将数组中的每个元素*2
        int[] arr = {1, 2, 3};
        transform1(arr);
        printArray(arr);

        int[] output = transform2(arr);
        printArray(output);
    }
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    //直接修改原数组
    public static void transform1(int[] arr) {
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = arr[i] * 2;
        }
    }
    //返回一个新的数组
    public static int[] transform2(int[] arr) {
        int[] ret = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ret[i] = arr[i] * 2;
        }
        return ret;
    }
    //数组作为方法的参数
/*    public static void main2(String[] args) {
        int[] arr = {1, 2, 3};
        printArray(arr);
        int num = 0;
        func1(num);
        System.out.println("num = " + num);
        func2(arr);
        System.out.println("arr[0] = " + arr[0]);
    }
    //打印数组内容
    public static void printArray(int[] a) {
        for (int x : a) {
            System.out.println(x);
        }
    }
    // 参数传内置类型
    public static void func1(int x) {
        x = 10;
        System.out.println("x = " + x);
        // 执行结果 x = 10 num = 0
    }
    // 参数传数组类型
    public static void func2(int[] a) {
        a[0] = 10;
        System.out.println("a[0] = " + a[0]);
        // 执行结果 a[0] = 10 arr[0] = 10
    }*/

    public static void main1(String[] args) {
        // 动态初始化
        // 数据类型[] 数组名称 = new 数据类型 [] { 初始化数据 };
        int[] arr = new int[]{1, 2, 3};

        // 静态初始化
        // 数据类型[] 数组名称 = { 初始化数据 };
        int[] arr2 = {1, 2, 3};

        // 获取数组长度
        System.out.println("length: " + arr.length); // 执行结果: 3
        // 访问数组中的元素
        System.out.println(arr[1]); // 执行结果: 2
        System.out.println(arr[0]); // 执行结果: 1
        arr[2] = 100;
        System.out.println(arr[2]); // 执行结果: 100
        //遍历数组
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        //使用 for-each 遍历数组
        for (int x : arr) {
            System.out.println(x);
        }
    }
}
