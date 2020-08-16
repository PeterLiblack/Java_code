//年会抽奖

import java.util.*;

public class Main {
	public static void main(String[] args) {
		// 输入
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int n = scan.nextInt(); // 代表测试数据的组数
			float sum1 = factorial(n);
			float sum2 = count(n);
			//将得到的分子分母进行相除，就可以得到概率了。
			float result1 = (sum2/sum1)*100;
			System.out.println(String.format("%.2f", result1) + "%");
		}
	}
	/**
	* 错排算法
	* @param n
	* @return
	*/
	public static float count(int n) {
		if(n==1){
			return 0;
		}else if(n==2){
			return 1;
		}else{
			return (n-1)*(count(n-1)+count(n-2));
		}
	}
	/**
	* n的阶乘
	* @param num
	* @return
	*/
	public static float factorial(int num) {
		float result = 1;
		if(num==0){
			return 1;
		}else if (num > 0) {
			result = num * factorial(num - 1);
		}
		return result;
	}
}




//数字和为sum的方法数
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();// 数组长度为n表示n个数字
		int sum = scanner.nextInt();// 部分元素求和sum
		int[] value = new int[n];//初始化数组
		long[] dp = new long[sum + 1];//动态规划数组
		dp[0] = 1;//index=0的初始化值
		for (int i = 0; i < n; i++) {
			value[i] = scanner.nextInt();
			for (int j = sum; j >= 0; j--) {
				if (j >= value[i]) {
					dp[j] += dp[j - value[i]];
				}
			}
		}
		System.out.println(dp[sum]);
	}
}