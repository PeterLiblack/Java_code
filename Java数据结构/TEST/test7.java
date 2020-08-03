//输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        //检查输入的特殊情况
        if(input==null || input.length<=0 || input.length<k){
            return list;
        }
        //构建最大堆
        for(int len=k/2-1; len>=0; len--){
            adjustMaxHeapSort(input,len,k-1);
        }
        //从第k个元素开始分别与最大堆的最大值做比较，如果比最大值小，则替换并调整堆。
        //最终堆里的就是最小的K个数。
        int tmp;
        for(int i=k; i<input.length; i++){
            if(input[i]<input[0]){
                tmp=input[0];
                input[0]=input[i];
                input[i]=tmp;
                adjustMaxHeapSort(input,0,k-1);
            }
        }
        for(int j=0; j<k; j++){
            list.add(input[j]);
        }
        return list;
    }
     
    public void adjustMaxHeapSort(int[] input, int pos, int length){
        int temp;
        int child;
        for(temp=input[pos]; 2*pos+1<=length; pos=child){
            child=2*pos+1;
            if(child<length && input[child]<input[child+1]){
                child++;
            }
            if(input[child]>temp){
                input[pos]=input[child];
            }else{
                break;
            }
        }
        input[pos]=temp;
    }
}





//某餐馆有n张桌子，每张桌子有一个参数：a 可容纳的最大人数； 
//有m批客人，每批客人有两个参数:b人数，c预计消费金额。 
//在不允许拼桌的情况下，请实现一个算法选择其中一部分客人，使得总预计消费金额最大

import java.util.*;
 
/**
 * 基本思路就是：桌子序列升序排列，客人按照预定花钱多少降序排序，
 * 然后贪心法从钱多的客人开始招呼。但是这题时间复杂度卡得太紧，
 * 在遍历能容得下第i批客人的时候需要二分查找去找否则超时
 */
public class Main{
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();  // n table
            int m = sc.nextInt();  // m customers
            int[] table = new int[n];
            for(int i=0;i<n;i++)
                table[i]=sc.nextInt();  // volume of a table
             
            int[][] cus = new int[m][2];
            for(int j=0;j<m;j++){
                cus[j][0]=sc.nextInt(); // number of customers
                cus[j][1]=sc.nextInt(); // money
            }
             
            Arrays.sort(table);
            Arrays.sort(cus, new Comparator<int[]>(){
 
            public int compare(int[] a, int[] b){
 
               return b[1]-a[1];
 
}
            });
             
            long res = 0L;
            int index = 0;
            boolean[] tableb = new boolean[n];
            for(int i=0;i<m;i++){
                if(cus[i][0]>table[n-1])
                    continue;
                index = bs(table,cus[i][0]);
                while(index<n && tableb[index]==true)
                    index++;
                if(index<n){
                    res += cus[i][1];
                    tableb[index]=true;
                }
            }
             
            System.out.println(res);
        }
        sc.close();
    }
     
    private static int bs(int[] num, int tar){
        int low=0;
        int high=num.length-1;
        int mid=0;
        while(low<=high){
            mid=(high+low)>>1;
            if(num[mid]>=tar)
                high=mid-1;
            else
                low=mid+1;
        }
         
        return low;
    }
}




//读入一个字符串str，输出字符串str中的连续最长的数字串
import java.util.Scanner;

/* 算法思想：用max表示经过的数字长度最大值，count表示数字计数器，当为字母时重置为0
 *  end表示数字尾部，每次满足数字时，对max进行判断，当max小于于count时，更新max和end
 */
public class Main {
  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      while(scanner.hasNext()){
          String str = scanner.nextLine();
          int max = 0,count=0,end=0;
          for(int i=0;i<str.length();i++){
              if(str.charAt(i)>='0' && str.charAt(i)<='9'){
                  count++;
                  if(max<count){
                      max= count;
                      end = i;
                  }
              }else{
                  count = 0;
              }
          }
          System.out.println(str.substring(end-max+1,end+1));
      }
  }
}