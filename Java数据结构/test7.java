import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

/**
 * 基于比较的排序
 */

public class TestSort {

    /**
     * 时间复杂度：
     *   最坏情况是：O(n^2)   最好情况(有序的情况)：O(n)
     *   非常重要的5个字：越有序越快。
     * 空间复杂度：O(1)
     * 稳定性：稳定的排序
     * @param array
     */
    public static void insertSort(int[] array) {
        int tmp = 0;
        for (int i = 1; i < array.length; i++) {
            tmp = array[i];
            int j;
            for (j = i-1; j >= 0 ; j--) {
                if(array[j] > tmp) {
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }

    /**
     * 直接插入排序：
     * @param array
     * @param gap
     */
    public static void shell(int[] array,int gap) {
        int tmp = 0;
        for (int i = gap; i < array.length; i+=1) {
            tmp = array[i];
            int j;
            for (j = i-gap; j >= 0 ; j-=gap) {
                if(array[j] > tmp) {
                    array[j+gap] = array[j];
                }else {
                    break;
                }
            }
            array[j+gap] = tmp;
        }
    }
    //稳定性：不稳定
    public static  void  shellSort(int[] array) {
        int[] drr = {5,3,1};
        for (int i = 0; i < drr.length; i++) {
            shell(array,drr[i]);
        }
    }

    /**
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：不稳定排序
     * @param array
     */
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length ; j++) {
                if(array[j] < array[i]) {
                    int tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
            }
        }
    }
    public static void adjustDown(int[] array,int root,int len) {
        int parent = root;
        int child = 2*parent+1;
        while (child < len) {
            //最起码有左孩子
            if(child+1 < len && array[child] < array[child+1]) {
                child++;
            }
            if(array[child] > array[parent]) {
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
                parent = child;
                child = 2*parent+1;
            }else {
                break;
            }
        }
    }

    public static void createHeap(int[] array) {
        for (int i = (array.length-1-1)/2; i>= 0 ; i--) {
            adjustDown(array,i,array.length);
        }
    }

    /**
     * 时间复杂度：O(nlogn)   不管有序还是无序都是
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     * @param array
     */
    public static void heapSort(int[] array) {
        createHeap(array);
        int end = array.length-1;
        while (end > 0) {
            int tmp = array[0];
            array[0] = array[end];
            array[end] = tmp;
            adjustDown(array,0,end);
            end--;
        }
    }

    /**
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：稳定的排序
     * @param array
     */
    public static void bubbleSort(int[] array) {
        //i  表示趟数
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }
    public static void bubbleSort1(int[] array) {
        boolean flg = false;
        //i  表示趟数
        for (int i = 0; i < array.length-1; i++) {
            flg = false;
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    flg = true;
                }
            }
            if(flg == false) {
                return;
            }
        }
    }

    /**
     * 时间复杂度：
     *     nlogn         最坏情况： 1 2 3 4 5 6 7 8 9 / 9 8 7 6 5 4 3 2 1   O(n^2)
     * 空间复杂度：
     *     logn           O(n)
     * 稳定性：不稳定
     * @param array
     * @param low
     * @param high
     * @return
     */
    public static int partition(int[] array,int low,int high) {
        int tmp = array[low];
        while (low < high) {
            while (low < high && array[high] >= tmp) {
                high--;
            }
            array[low] = array[high];
            while (low < high && array[low] <= tmp) {
                low++;
            }
            array[high] = array[low];
        }
        array[low] = tmp;
        return low;
    }

    public static void insert_sort(int[] array,int start,int end) {
        int tmp = 0;
        for (int i = start+1; i <= end; i++) {
            tmp = array[i];
            int j;
            for (j = i-1; j >= start ; j--) {
                if(array[j] > tmp) {
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }

    public static void swap(int[] array,int i,int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void three_num_mid(int[] array,int left,int right) {
        //array[mid] <= array[left] <= array[right]
        int mid = (left+right)/2;
        if(array[left] > array[right]) {
            swap(array,left,right);
        }
        if(array[mid] > array[left]) {
            swap(array,left,mid);

        }
        if(array[mid] > array[right]) {
            swap(array,mid,right);
        }
    }

    public static void quick(int[] array,int left,int right) {
        if(left >= right) {
            return;
        }
        //4 5 6  优化方式一：当待排序序列的数据个数小于等于100的时候，用直接插入排序。
        if(right-left+1 <= 100) {
            insert_sort(array,left,right);
            return;
        }

        three_num_mid(array,left,right);

        int par = partition(array, left, right);
        quick(array,left,par-1);
        quick(array,par+1,right);
    }

    public static void quickSort1(int[] array) {
        quick(array,0,array.length-1);
    }

    /**
     * 非递归实现快速排序
     * @param array
     */
    public static void quickSort(int[] array) {
        Stack<Integer> stack = new Stack<>();

        int left = 0;
        int right = array.length-1;

        int par = partition(array,left,right);

        if(par > left+1) {
            stack.push(left);
            stack.push(par-1);
        }
        if(par < right-1) {
            stack.push(par+1);
            stack.push(right);
        }
        while (!stack.empty()) {
            right = stack.pop();
            left = stack.pop();
            par =  partition(array,left,right);

            if(par > left+1) {
                stack.push(left);
                stack.push(par-1);
            }
            if(par < right-1) {
                stack.push(par+1);
                stack.push(right);
            }
        }

    }
    //归并--》
    public static void merge(int[] array,int low,int mid,int high) {
        int s1 = low;
        int s2 = mid+1;
        int len = high-low+1;
        int[] ret = new int[len];
        int i = 0;//用来表示ret数组的下标

        while (s1 <= mid && s2 <= high) {
            if(array[s1] <= array[s2]) {
                ret[i++] = array[s1++];
            }else {
                ret[i++] = array[s2++];
            }
        }

        while (s1 <= mid) {
            ret[i++] = array[s1++];
        }

        while (s2 <= high) {
            ret[i++] = array[s2++];
        }

        for (int j = 0; j < ret.length; j++) {
            array[j+low] = ret[j];
        }

    }

    public static void mergeSortInternal(int[] array,int low,int high) {
        if(low >= high) {
            return;
        }
        //分解
        int mid = (low+high)>>>1;
        mergeSortInternal(array,low,mid);
        mergeSortInternal(array,mid+1,high);
        //合并
        merge(array,low,mid,high);
    }

    /**
     * 时间复杂度：nlogn
     * 空间复杂度：O(n)
     * 稳定性：稳定的排序
     * 外排序：磁盘。
     * @param array
     */
    public static void mergeSort(int[] array) {
        mergeSortInternal(array,0,array.length-1);
    }

    public static void main2(String[] args) {
        int[] array = new int[10_0000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
            //array[i] = random.nextInt(10_0000);
        }
        long start = System.currentTimeMillis();
        quickSort(array);
        long end =  System.currentTimeMillis();
        System.out.println(end-start);
    }

    public static void main(String[] args) {
        int[] array = {12,5,9,34,6,8,33,56,89,0,7,4,22,55,77};
        System.out.println(Arrays.toString(array));
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
