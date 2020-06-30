//实际成绩 绩点 90——100 4.0 85——89 3.7 82——84 3.3 78——81 3.0 75——77 2.7 
//72——74 2.3 68——71 2.0 64——67 1.5 60——63 1.0 60以下 0 
//1．一门课程的学分绩点=该课绩点*该课学分 
//2．总评绩点=所有学科绩点之和/所有课程学分之和 
//现要求你编写程序求出某人A的总评绩点（GPA）。

import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
        int n=sc.nextInt(); //输入总共有多少门课程
        int[] gradeCredit=new int[n];//存储每门课学分的数组
        int[] grade=new int[n];//存储每门课分数的数组
 
        for(int i=0;i<n;i++){
            gradeCredit[i]=sc.nextInt(); //读入输入的第二行
        }
        for(int i=0;i<n;i++){
            grade[i]=sc.nextInt();//读入输入的第三行
        }
        System.out.printf("%.2f",averageCredit(gradeCredit,grade));
    }
}
    public static double averageCredit(int[] gradeCredit,int[] grade){
        double sum=0.0;//表示所有课程加起来应得的学分和
        double allClassCredit=0.0; //表示该学生能实际得到的学分绩点
        for(int i=0;i<grade.length;i++){
            allClassCredit+=gradeCredit[i]*GPA(grade[i]);
            sum+=gradeCredit[i];
        }
        return allClassCredit/sum;
    }
    //求每门课的成绩对应的学分绩点
    public static double GPA(int grade){
        double gpa = 0.0;
        if(grade>=90&&grade<=100)
            gpa=4.0;
 
        if(grade>=85&&grade<=89)
            gpa=3.7;
 
        if(grade>=82&&grade<=84)
            gpa=3.3;
 
        if(grade>=78&&grade<=81)
            gpa=3.0;
 
        if(grade>=75&&grade<=77)
            gpa=2.7;
 
        if(grade>=72&&grade<=74)
            gpa=2.3;
 
        if(grade>=68&&grade<=71)
            gpa=2.0;
 
        if(grade>=64&&grade<=67)
            gpa=1.5;
 
        if(grade>=60&&grade<=63)
            gpa=1.0;
 
        if(grade<60)
            gpa=0.0;
 
        return gpa;
    }
}


//1、中文大写金额数字前应标明“人民币”字样。中文大写金额数字应用壹、贰、叁、肆、伍、
//陆、柒、捌、玖、拾、佰、仟、万、亿、元、角、分、零、整等字样填写。
//2、中文大写金额数字到“元”为止的，在“元”之后，应写“整字，如￥ 532.00
//应写成“人民币伍佰叁拾贰元整”。在”角“和”分“后面不写”整字。
//3、阿拉伯数字中间有“0”时，中文大写要写“零”字，阿拉伯数字中间连续有几个“0”时，
//中文大写金额中间只写一个“零”字，如￥6007.14，应写成“人民币陆仟零柒元壹角肆分“。

import java.util.Scanner;

public class Main{
     
    static String[] map = {"壹","贰","叁","肆","伍","陆","柒","捌","玖"};
     
    public static void main(String[] args){
         Scanner scan = new Scanner(System.in);
         while(scan.hasNext()){
             String number = scan.next();
             resolve(number);
         }
         scan.close();
    }
     
    public static void resolve(String str){
 
        String[] strArr = str.split("\\.");
        int number = Integer.valueOf(str.split("\\.")[0]);
        
        StringBuffer res = new StringBuffer("人民币");
        int yi = (int)(number/100000000);
        if(yi!=0){
            res.append(resolveQian(yi)).append("亿");
            number = number-yi*100000000;
        }
         
        int wan = (int)(number/10000);
        if(wan!=0){
            res.append(resolveQian(wan)).append("万");
            number = number-wan*10000;
        }
         
         //处理千百十个位
        String beforePointString = resolveQian(number);
        if(beforePointString.length()>1){
             res.append(beforePointString).append("元");
        }
         
        //若有小数点，处理小数点后面位数
        if(strArr.length>1){
             String afterPointStr = strArr[1];
             //System.out.println(afterPointStr);
             res.append(handleNumberAfterPoint(afterPointStr));
        }
         
        //在resolveQian() 方法里可能会返回  零xxx
        //但在最高为不能有"零"
        String resString = res.toString();
       
        if(resString.length()>4 && resString.charAt(3)=='零' && resString.charAt(4)!='元'){
           //System.out.println(resString.substring(0,3));
            resString = resString.substring(0,3)+resString.substring(4);
        }
 
        System.out.println(resString);
         
    }
     
    //处理4位数 千百十个位
    public static String resolveQian(double temp){
    
        StringBuffer resBuffer = new StringBuffer();
         
        //千位
        int qian = (int)(temp/1000);
        if(qian!=0){
            resBuffer.append(map[qian-1]).append("仟");
            temp = temp-qian*1000;
        }
         
        //百位
        int bai = (int)(temp/100);
        if(bai!=0){
            resBuffer.append(map[bai-1]).append("佰");
            temp = temp-bai*100;
        }
        //注意:零 只会添加在 百位和十位
        if(qian!=0 && bai==0){
            resBuffer.append("零");
        }
         
        //十位
        int shi = (int)(temp/10);
        if(shi!=0){
            if(shi!=1){
                resBuffer.append(map[shi-1]);
            }
            resBuffer.append("拾");
            temp = temp-shi*10;
        }
         
        //注意：0
        if(bai!=0&&shi==0){
            resBuffer.append("零");
        }
         
        //个位
        int ge = (int)(temp%10);
         
         
        if(ge!=0){
            //5,0001 这种情况，千百十位均为0
            if(qian==0&&bai==0&&shi==0){
                resBuffer.append("零");
            }
            resBuffer.append(map[ge-1]);
        }
        String res = resBuffer.toString();
        return res;
    }
     
    //处理小数点后面的数
    public static String handleNumberAfterPoint(String str){
        String res = "";
        if(str.equals("00") ||str.equals("0")){
            res = "整";
        }else{
            if(str.charAt(0)!='0'){
                res += map[Integer.valueOf(str.charAt(0)+"")-1]+"角";
            }
            if(str.length()>1 && str.charAt(1)!='0'){
                res += map[Integer.valueOf(str.charAt(1)+"")-1]+"分";
            }
        }
        return res;
    }
}


//对于给定的正整数 n，计算其十进制形式下所有位置数字之和，并计算其平方的各位数字之和。

import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        //int 可以表示的最大数 2147483647
        //1600000000 可以表示
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int i = scanner.nextInt();
            int j =i*i;
            int sum1=0;
            while (i>0){
                sum1+= i%10;
                i=i/10;
            }
            int sum2=0;
            while (j>0){
                sum2+= j%10;
                j=j/10;
            }
            System.out.println(sum1+" "+sum2);
        }
    }
}


//记票统计

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            //统计人头
            int n = scan.nextInt();
            LinkedHashMap<String,Integer> map = new LinkedHashMap<String,Integer>();
            scan.nextLine();
            String str = scan.nextLine();
            String[] array = str.split(" ");
            for(int i=0;i<array.length;i++){
                map.put(array[i],0);
            }
            map.put("Invalid",0);
           //投票计数
            int m = scan.nextInt();
            scan.nextLine();
            String strr = scan.nextLine();
            String[] arrays = strr.split(" ");
            for(String s :arrays){
                if(map.containsKey(s)){
                    map.put(s,map.get(s)+1);
                }else{
                     map.put("Invalid",map.get("Invalid")+1);
                }
            }
            Set<String> set = map.keySet();
            for(String s :set){
                System.out.println(s+" : "+map.get(s));
                  
            }
        }
    }
}


//输入一个数n，然后输入n个数值各不相同，再输入一个值x，
//输出这个值在这个数组中的下标（从0开始，若不在数组中则输出-1）。

import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            if(n <1 || n> 200){
                continue;
            }
            int [] num = new int [n];
            for(int i = 0; i <num.length; i ++){
                num [i] = sc.nextInt();
            }
            int x = sc.nextInt();
            int j = 0;
            for(; j <num.length; j ++){
                if(x == num [j]){
                    System.out.print(j);
                    break;
                }
            }
            if(j == num.length){
                System.out.print("-1");
            }
        }
    }
}


//整数与IP地址间的转换

import java.util.*;
 
//遇到的问题，数组越界，输入格式不正确，应都为String输入；
//int型溢出，要换为long型
public class Main { 
    public static void main(String[] args) {
         Scanner in=new Scanner(System.in);
         while(in.hasNext()){
            String ip=in.nextLine();
            String p=in.nextLine();
            System.out.println(IptoTen(ip));
            TentoIp(p);
             
        }
    }
 
    private static void TentoIp(String p) {
        long temp=Long.parseLong(p);
        String ip=Long.toBinaryString(temp);
         
        StringBuilder sb=new StringBuilder();
        if(ip.length()<32) {
            for(int i=0;i<(32-ip.length());i++) {
                sb.append(0);
            }
            sb.append(ip);
        }else if(ip.length()==32) {
            sb.append(ip);
        }
         
        for(int i=0;i<sb.length()-8;i=i+8) {
             
            System.out.print(Integer.parseInt(sb.substring(i,i+8),2)+".");
        }
         
        System.out.println(Integer.parseInt(sb.substring(sb.length()-8,sb.length()),2));
         
    }
 
    private static long IptoTen(String ip) {
        String[] arr=ip.split("\\.");
        long n=Long.parseLong(arr[0]);
         
        for(int i=1;i<arr.length;i++) {
            n=n<<8;
            n=n+Long.parseLong(arr[i]);
        }
         
        return n;
    }
   
}