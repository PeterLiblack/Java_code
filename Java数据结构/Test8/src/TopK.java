import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author Li_ZW
 * @Date: 2020/05/26
 * @Time: 15:54
 * @Description
 * topk问题
 */

class MyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2-o1;
    }
}

public class TopK {
    public static Integer[] topK(int[] array, int k) {
        MyComparator myComparator = new MyComparator();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for (int i = 0; i < array.length; i++) {
            if (maxHeap.size() < k) {
                maxHeap.offer(array[i]);
            }else {
                Integer val = maxHeap.peek();
                if (val != null && val > array[i]) {
                    maxHeap.poll();
                    maxHeap.offer(array[i]);
                }
            }
        }

        Integer[] ret = new Integer[k];
        for (int i = 0; i < k; i++) {
            int v = maxHeap.poll();
            ret[i] = v;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] array = {29,13,1,17,8,18,7,20,15};
        Integer[] ret = topK(array,4);
        System.out.println(Arrays.toString(ret));
    }
}
