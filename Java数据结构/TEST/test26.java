//有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
//给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。

import java.util.*;
 
public class Finder {
    public static int findKth(int[] a, int n, int K) {
        quick(a,0,n-1);
        return a[n-K]; //因为下边我们做的排序是升序，所以这里这么返回
    }
    //第二步骤
    private static void quick(int[] array, int low, int high) {
        if(low==high){ //这个是为了防止传进来的是一个空数组，去掉这部分也行其实
            return; 
        }
        int par=partion(array,low,high);
        //递归左边
        if(par>low+1){
            quick(array,low,par-1);
        }
 
        //递归右边
        if(par+1<high){
            quick(array,par+1,high);
        }
    }
    //第一步骤
    public static int partion(int[] array,int low,int high){
        int tmp=array[low]; //将基准值先记录好，方便最后进行赋值
        while(low<high){
         /*这里要满足&&左右的条件，有人可能认为外边就定义了为啥里边还要定义：
          那是因为里外没有什么绝对的关系，外边满足了low<high，里边仍然有可能会出现low>high的情况
            */
            //先从右边high指向的值向左进行遍历
            while((low<high)&&array[high]>=tmp){ 
                high--;//如果出现比基准值大的数字，high指针继续向左移动
            }
            if(low==high){ //如果相等，说明这个小数组遍历完了，进行下一个小数组的遍历
                break;
            }else{
            //array[high]<tmp,则将array[high]的值覆盖到array[low]的地方，然后步骤跳转到low指向的位置
                array[low]=array[high];
            }
            while((low<high)&&array[low]<=tmp){
                low++;//如果出现比基准值小的数字，high指针继续向右移动
            }
            if(low==high){//如果相等，说明这个小数组遍历完了，进行下一个小数组的遍历
                break;
            }else{
             //array[low]>tmp,则将array[low]的值覆盖到array[high]的地方，然后步骤跳转到下一次的while循环
                array[high]=array[low];
            }
        }
        array[low]=tmp;
         //最后在循环完毕后，将基准值赋值到array[low]或者array[high]的位置
        return low;
    }
}