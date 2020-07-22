//给定一个数字arr，其中只有有两个数字出现了奇数次，其它数字都出现了偶数次，按照从小到大顺序输出这两个数。
import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int retExclusive = 0;
            for (int i = 0; i <n ; i++) {
                retExclusive^=arr[i];
            }
            int index = findIndex(retExclusive);
            int num1 = 0;
            int num2 = 0;
            for (int i = 0; i <n ; i++) {
                if (judgeIndex(arr[i],index)){
                    num1^=arr[i];
                }else{
                    num2^=arr[i];
                }
            }
            if (num1<num2){
                System.out.println(num1+" "+num2);
            }else{
                System.out.println(num2+ " " + num1);
            }
        }
        }
        public static int findIndex(int num){
        //在整数num中找到最右边是1的位置
        int index = 0;
        while ((num&1)==0){
            num>>=1;
            index++;
        }
        return index;
        }
        public static boolean judgeIndex(int num,int index){
        //判断整数num右边第num位是否为1
        num>>=index;
        return ((num&1)==1);
        }
		
}


//给定一个不含有重复值的数组 arr，找到每一个 i 位置左边和右边离 i 位置最近且值比 arr[i] 小的位置。返回所有位置相应的信息。

import java.util.Scanner;
import java.util.Stack;
 
public class Main {
 
    public static int[][] getNearLessNoRepeat(int[] arr) {
        int[][] res = new int[arr.length][2];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            // 如果当前遍历到的数组的值小，需要弹出
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int popIndex = stack.pop();
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
                res[popIndex][0] = leftLessIndex;
                res[popIndex][1] = i;
            }
            // 否则当前遍历到的数组的值大，压入不会破坏stack从栈顶到栈底递减的顺序
            stack.push(i);
        }
        // 遍历结束，清算栈中剩下的位置，因为没有当前遍历到的位置，右边位置一律为-1
        while (!stack.isEmpty()) {
            int popIndex = stack.pop();
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
            res[popIndex][0] = leftLessIndex;
            res[popIndex][1] = -1;
        }
        return res;
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] data = new int[n];
            for (int i = 0; i < data.length; i++) {
                data[i] = sc.nextInt();
            }
            int[][] result = getNearLessNoRepeat(data);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < result.length; i++) {
                sb.append(result[i][0]).append(" ").append(result[i][1]).append('\n');
            }
            System.out.print(sb);
        }
    }
}