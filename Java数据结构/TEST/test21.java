//数字之和
import java.util.Scanner;
public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(); //输入的数字
		int b = a*a; //平方
		System.out.print(add(a)); //a的各位数字之和
		System.out.print(" " + add(b)); //b的各位数字之和（a的平方）
	}
	
	public static int add(int a){
		int sum=0;
		for(;a != 0;){
			sum = sum + a % 10; //取模计算出各位数字，相加计算各位数字之后
			a = a/10;
		}
		return sum;
	}
}




//记票统计
import java.util.Scanner;
import java.util.HashMap;
import java.util.Set;

public class Main{
	public static void main(String args[]){
		//控制台输入数据
		Scanner in = new Scanner(System.in);
		while (in.hasNext()){
			//候选人人数
			int n = in.nextInt();
			String[] s = new String[n];
			//记录候选人
			HashMap<String,Integer> hs = new HashMap<String,Integer>();
			for(int i=0;i<n;i++){
				String temp = in.next();
				hs.put(temp,0);
				s[i] = temp;
			}
			//投票人数
			int m = in.nextInt();
			Set<String> keys = hs.keySet();
			int cnt = 0;
			for(int i=0;i<m;i++){
				//投票
				String tick = in.next();
				if(keys.contains(tick)){
					hs.put(tick, hs.get(tick)+1);
				}else{
					cnt++;
				}
			}
			//输出结果
			for(String k:s){
				System.out.println(k+" : "+hs.get(k));
			}
			System.out.println("Invalid : "+cnt);
		}
		in.close();
	}
}