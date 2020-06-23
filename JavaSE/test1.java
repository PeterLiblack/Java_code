//有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，问每个月的兔子总数为多少？

import java.util.*;
 
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int monthCount = in.nextInt();
            System.out.println(getTotalCount(monthCount));
        }
        in.close();
    }
     
    public static int getTotalCount(int monthCount){
        if(monthCount==1 || monthCount==2){
            return 1;
        }
         
        return getTotalCount(monthCount-1)+getTotalCount(monthCount-2);
    }
}