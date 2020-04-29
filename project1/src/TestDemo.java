import java.util.Arrays;

import static java.util.Arrays.binarySearch;

/**
 * @Author Li_ZW
 * @Date: 2020/04/29
 * @Time: 13:42
 * @Description
 * 数组练习
 *
 */
public class TestDemo {

    public static void main1(String[] args) {
        //给定整型数组, 把所有的偶数放到数组前面, 把所有奇数放到数组后面.
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(arr));
        transform(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void transform(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            while (left < right && arr[left] % 2 == 0) {
                left++;
            }
            while (left < right && arr[right] % 2 != 0) {
                right--;
            }
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
        }

    }

    public static void main2(String[] args) {
        //给定两个整型数组, 交换两个数组的内容.
        int[] arr1 = {1, 3, 5, 7, 9};
        int[] arr2 = {2, 4, 6, 8, 10};
        exchange(arr1, arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    private static void exchange(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            int tmp = arr1[i];
            arr1[i] = arr2[i];
            arr2[i] = tmp;
        }
    }


    public static void main3(String[] args) {
        //给定一个整型数组, 实现冒泡排序(升序排序)
        int[] arr = {1, 9, 3, 7, 5};
        //Arrays.sort(arr);

        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {
        for (int left = 0; left < arr.length; left++) {
            for (int right = arr.length - 1; left < right; right--) {
                if (arr[right - 1] > arr[right]) {
                    int tmp = arr[right];
                    arr[right] = arr[right - 1];
                    arr[right - 1] = tmp;
                }
            }

        }
    }

    public static void main4(String[] args) {
        //给定一个整型数组, 判定数组是否有序（递增）
        int[] arr = {1, 3, 5, 9, 7};
        int[] arr1 = {1, 3, 5, 7, 9};

        isSorted(arr);
        isSorted(arr1);
        System.out.println(isSorted(arr));
        System.out.println(isSorted(arr1));
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main5(String[] args) {
        //给定一个有序整型数组, 实现二分查找
        int[] arr = {1, 3, 4, 6, 7, 9};
        int ret = binarySearch(arr, 6);
        int ret1 = myBinarySearch(arr, 6);
        System.out.println(ret);
        System.out.println(ret1);
    }

    private static int myBinarySearch(int[] arr, int i) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == i) {
                return mid;
            } else if (arr[mid] > i) {
                right = mid;
                right--;
            } else if (arr[mid] < i) {
                left = mid;
                left++;
            }
        }
        return -1;
    }

    public static void main6(String[] args) {
        //实现一个方法 copyOf, 对一个整型数组进行拷贝, 得到一个新的数组
        int[] arr = {1, 3, 2, 4, 6, 8};
        int newArr1[] = Arrays.copyOf(arr, arr.length);
        System.out.println(Arrays.toString(newArr1));

        int[] newArr = myCopyOf(arr);
        System.out.println(Arrays.toString(newArr));
    }

    private static int[] myCopyOf(int[] arr) {
        int[] ret = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ret[i] = arr[i];
        }
        return ret;
    }

    public static void main7(String[] args) {
        //实现一个方法 toString, 把一个整型数组转换成字符串.
        //例如数组 {1, 2, 3} , 返回的字符串为 "[1, 2, 3]", 注意 逗号 的位置和数量.
        int[] arr = {1, 2, 3};
        String ret = toString(arr);
        System.out.println(ret);
    }

    private static String toString(int[] arr) {
        String ret = "[";
        for (int i = 0; i < arr.length; i++) {
            ret += arr[i];
            if (i != arr.length - 1) {
                ret += ",";
            }
        }
        ret += "]";
        return ret;
    }

    public static void main8(String[] args) {
        //实现一个方法 avg, 以数组为参数, 求数组中所有元素的平均值(注意方法的返回值类型).
        int arr[] = {2, 4, 6, 1, 3, 7};
        double ret = avg(arr);
        System.out.println(ret);
    }

    private static double avg(int[] arr) {
        int sum = 0;
        /*for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }*/

        for (int x : arr) {
            sum += x;
        }
        double ret = (double) sum / arr.length;
        return ret;
    }

    public static void main9(String[] args) {
        //实现一个方法 sum, 以数组为参数, 求数组所有元素之和.
        int[] arr = {1, 3, 5, 7, 9};
        int ret = sum(arr);
        System.out.println(ret);
    }

    private static int sum(int[] arr) {
        int ret = 0;
        for (int x : arr) {
            ret += x;
        }
        return ret;
    }

    public static void main10(String[] args) {
        //实现一个方法 transform, 以数组为参数, 循环将数组中的每个元素 乘以 2 , 并设置到对应的数组元素上.
        //例如 原数组为 {1, 2, 3}, 修改之后为 {2, 4, 6}
        int[] arr = {1, 2, 3};
        System.out.println(Arrays.toString(arr));

        transform2(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void transform2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * 2;
        }
    }

    public static void main11(String[] args) {
        //实现一个方法 printArray, 以数组为参数, 循环访问数组中的每个元素, 打印每个元素的值.
        int[] arr = {3, 4, 5, 9, 8};
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int x : arr) {
            System.out.println(x);
        }
    }

    public static void main12(String[] args) {
        //创建一个 int 类型的数组, 元素个数为 100, 并把每个元素依次设置为 1 - 100
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
    }

}