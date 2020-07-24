//给定一个长度为N(N>1)的整型数组A，可以将A划分成左右两个部分，
//左部分A[0..K]，右部分A[K+1..N-1]，K可以取值的范围是[0,N-2]。
//求这么多划分方案中，左部分中的最大值减去右部分最大值的绝对值，最大是多少？
//给定整数数组A和数组的大小n，请返回题目所求的答案。

import java.util.*;
 
public class MaxGap {
    public int findMaxGap(int[] A, int n) {
        // write code here
        int mmax = -1;
        for(int k = 0 ; k < n -1 ; k ++){
            int maxLeft = -1;
            int maxRight = -1;
            for(int i = 0 ; i < n ; i ++){
                if(i <= k){
                    maxLeft = Math.max(maxLeft,A[i]);
                }else {
                    maxRight = Math.max(maxRight,A[i]);
                }
            }
            mmax = Math.max(Math.abs(maxLeft-maxRight),mmax);
        }
        return mmax;
    }
}



//对于一个矩阵，请设计一个算法从左上角(mat[0][0])开始，顺时针打印矩阵元素。
//给定int矩阵mat,以及它的维数nxm，请返回一个数组，数组中的元素为矩阵元素的顺时针输出。

import java.util.*;
 
public class Printer {
    public int[] clockwisePrint(int[][] mat, int n, int m) {
       
        // write code here
        int startX = 0;
        int endX = m - 1;
        int startY = 0;
        int endY = n - 1;
        int index = 0;
        int[] result = new int[n * m];
 
        while (startX <= endX && startY <= endY) {
 
            // 从左到右打印
            if(startX <= endX){
                for (int i = startX; i <= endX; i++) {
                    result[index++] = mat[startY][i];
                }
            }
             
 
            // 从上往下打印
 
            if (startY < endY) {
 
                for (int i = startY + 1; i <= endY; i++) {
                    result[index++] = mat[i][endX];
                }
            }
 
            // 从右往左打印
            if (startX < endX && endY > startY) {
                for (int i = endX - 1; i >= startX; i--) {
                    result[index++] = mat[endY][i];
                }
            }
             
            // 从下往上打印
            if (startY < endY && endX > startX) {
                for (int i = endY - 1; i >= startY + 1; i--) {
                    result[index++] = mat[i][startX];
                }
            }
 
            startX++;
            endX--;
            startY++;
            endY--;
        }
        return result;
     
     
    }
}




//有 n 个学生站成一排，每个学生有一个能力值，牛牛想从这 n 个学生中按照顺序选取 k 名学生，
//要求相邻两个学生的位置编号的差不超过 d，使得这 k 个学生的能力值的乘积最大，
//你能返回最大的乘积吗？

import java.util.Scanner;
 
public class Main {
    // 参考 【小刀初试】的算法思想， Java版本，便于理解
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()) {
            int n = cin.nextInt();          // n 个学生
            int[] arr = new int [n+1];
            for (int i = 1; i <=n ; i++) {
                arr[i] = cin.nextInt();
            }
            int K = cin.nextInt();            // 选出K个
            int d = cin.nextInt();            // 两个学生的位置编号的差不超过 d
            long[][] fmax = new long[K+1][n+1]; // 记录最大乘积
            long[][] fmin = new long[K+1][n+1]; // 记录最小乘积
            // fmax[k][i]表示 : 当选中了k个学生，并且以第i个学生为结尾，所产生的最大乘积；
            // fmin[k][i]表示 : 当选中了k个学生，并且以第i个学生为结尾，所产生的最小乘积；
            //初始化第一行
            long  res = Integer.MIN_VALUE; // 记得用Long类型，考虑数值范围
            for (int i = 1; i <=n; i++) {
                fmax[1][i] = arr[i];
                fmin[1][i] = arr[i];
                for (int k = 2; k <=K; k++) {
                    for (int j = i-1 ; j > 0 &&  i-j<=d ; j--) {
                        fmax[k][i] = Math.max(fmax[k][i], Math.max(fmax[k-1][j] * arr[i], fmin[k-1][j] * arr[i]));
                        fmin[k][i] = Math.min(fmin[k][i], Math.min(fmax[k-1][j] * arr[i], fmin[k-1][j] * arr[i]));
                    }
                }
                res = Math.max(res ,fmax[K][i]);
            }
            System.out.println(res);
        }
    }
}



//首先一个正整数N，表示人员个数。 
//之后N行，每行三个数，分别对应马戏团员编号，体重和身高
//正整数m，表示罗汉塔的高度。

import java.util.*;
 
public class Main {
     
    static class People {
        int height;
        int weight;
 
        public People(int weight, int height) {
            this.height = height;
            this.weight = weight;
        }
    }
 
    public static void main(String[] args) {
 
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            People[] array = new People[n];
            for (int i = 0; i < n; ++i) {
                int index = scan.nextInt();
                array[index - 1] = new People(scan.nextInt(), scan.nextInt());
            }
 
            Arrays.sort(array, new Comparator<People>() {
                public int compare(People p1, People p2) {
                    int result = Integer.compare(p1.height, p2.height);
                    if (result != 0)
                        return result;
                    else
                        return Integer.compare(p1.weight, p2.weight);
                }
            });
 
            int[] dp = new int[n];
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < dp.length; ++i) {
                dp[i] = 1;
                for (int j = i - 1; j >= 0; --j) {
                    if (array[i].weight > array[j].weight
                        || (array[i].weight == array[j].weight && array[i].height == array[j].height)) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                max = Math.max(dp[i], max);
            }
            System.out.println(max);
        }
    }
}



//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
//例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
//超过数组长度的一半，因此输出2。如果不存在则输出0。

import java.util.Arrays;
 
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        Arrays.sort(array);
        int count=0;
         
        for(int i=0;i<array.length;i++){
            if(array[i]==array[array.length/2]){
                count++;
            }
        }
        if(count>array.length/2){
            return array[array.length/2];
        }else{
            return 0;
        }
         
    }
}




//开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
//处理：
//1、 记录最多8条错误记录，循环记录（或者说最后只输出最后出现的八条错误记录），对相同的错误记录（净文件名（保留最后16位）称和行号完全匹配）只记录一条，错误计数增加；
//2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
//3、 输入的文件可能带路径，记录文件名称不能带路径。

import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //LinkedHashMap可以保证按照存入顺序
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        int count = 0;
        while (sc.hasNextLine()) {
            String str_1 = sc.nextLine();
            //读取一行  存入一行至map中
            mapDispose(map, str_1);
        }
        // 输出后8位
            for (String st : map.keySet()) {
                count++;
                if (count > (map.size() - 8)) {
                    System.out.println(st + " " + map.get(st));
                }
            }
    }
     
    public static void mapDispose(Map<String, Integer> map, String str) {
        // "\\s" 是按照单个空格 、多个空格、tab制表符分割
        String[] strArr = str.split("\\s+");
        // "\\\\"按照反斜杠分割
        String[] nameArr = strArr[0].split("\\\\");
        int num = Integer.parseInt(strArr[1]);
        String name = nameArr[nameArr.length - 1];
        // 取最后有效的16个字符为最终文件名
        if (name.length() > 16) {
            name = name.substring(name.length() - 16);
        }
        // 将文件名和行号组成字符串 作为map的key值存放
        String key = name + " " + num;
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + 1);
        } else {
            map.put(key, 1);
        }
    }
}