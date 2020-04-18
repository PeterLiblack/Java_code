import java.util.Scanner;
import java.util.Random; 

public class HomeWork1 {
	// 13. 完成猜数字游戏
	public static void main(String[] args) { 
	 Random random = new Random(); // 默认随机种子是系统时间
	 Scanner sc = new Scanner(System.in); 
	 int toGuess = random.nextInt(100); 
	 // System.out.println("toGuess: " + toGuess); 
		 while (true) { 
			 System.out.println("请输入要输入的数字: (1-100)"); 
			 int num = sc.nextInt(); 
			 if (num < toGuess) { 
				 	System.out.println("低了"); 
				 } else if (num > toGuess) { 
				 	System.out.println("高了"); 
				 } else { 
					 System.out.println("猜对了"); 
					 break; 
			 } 
		 } 
		 sc.close(); 
	 }
	// 12. 获取一个数二进制序列中所有的偶数位和奇数位， 分别输出二进制序列。
	public static void main12(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 31; i >= 1; i -= 2) {
			System.out.print("奇数位 " + ((n >> i) & 1) + " ");
		}
		System.out.println();
		for (int i = 30; i >= 0; i -= 2) {
			System.out.print("偶数位 " + ((n >> i) & 1) + " ");
		}
		System.out.println();
	}
	// 11. 写一个函数返回参数二进制中 1 的个数 比如： 15 0000 1111 4 个 1
	public static void main11(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;
		for (int i = 0; i < 32; i++) {
			if (((n >> i) & i) == 1) {
				count++;
			}
		}
		System.out.println("count:" + count);
	}
	// 10. 编写代码模拟三次密码输入的场景。 
	// 最多能输入三次密码，密码正确，提示“登录成功”,
	// 密码错误， 可以重新输入，最多输入三次。三次均错，则提示退出程序
	public static void main10(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 3;
		while (count != 0) {
			System.out.println("请输入你的密码: ");
			String password = sc.nextLine();
			if (password.equals("123456")) {
				String.out.println("密码正确，登录成功！");
				break;
			} else {
				count--;
				System.out.println("你还有" + count + "次机会！");
			}
		}
	}
	// 9. 求出0～999之间的所有“水仙花数”并输出。
	// (“水仙花数”是指一个三位数，其各位数字的立方和确好等于该数本身，
	// 如；153＝1＋5＋3?，则153是一个“水仙花数”。)
	public static void main9(String[] args) {
		int i = 0;
		
		for (i = 1; i <= 999999; i++) {
			int tmp = i; //153
			int count = 0;
			while (tmp != 0) {
				tmp = tmp / 10; //15 1 0
				count++; //1 2 3
			}
			tmp = i; //153
			int sum = 0;
			while (tmp != 0) {
				sum += Math.pow(tmp % 10, count); //3,3  5,3  1,3
				tmp = tmp / 10; //15 1 0
			}
			if (sum == i) {
				System.out.println(sum);
			}
		}
	}
	// 8. 编写程序数一下 1到 100 的所有整数中出现多少个数字9。
	public static void main8(String[] args) {
		int i = 0;
		int count = 0;
		for (i = 1; i <= 100; i++) {
			if (i % 10 == 9) {
				count++;
			}
			if (i / 10 == 9) {
				count++;
			}
		}
		System.out.println(count);
	}
	// 7. 计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值。
	public static void main7(String[] args) {
		int i = 0;
		int flag = 1;
		double sum = 0.0;
		for (i = 1; i <= 100; i++) {
			sum += flag * (1.0 / i);
			flag = -flag;
		}
		System.out.println(sum);
	}
	// 6. 求两个正整数的最大公约数
	public static void main6(String[] args) {
		Scanner sc1 = new Scanner(System.in); 
		//Scanner sc2 = new Scanner(System.in); 
		int n1 = sc1.nextInt();//24
		int n2 = sc1.nextInt();//18
		int c = n2;
		while (n1 % n2 != 0) {
			c = n1 % n2;//6
			n1 = n2;
			n2 = c;
		}
		System.out.println("最大公约数是：" + c);
	}
	// 5. 输出乘法口诀表	
	public static void main5(String[] args) {
		int i = 0;
		for (i = 1; i <= 9; i++) {
			int j = 0;
			for (j = 1; j <= i; j++) {
				System.out.print(i + "*" + j + "=" + i*j + " ");
			}
			System.out.println();
		}
	}
	// 4. 输出 1000 - 2000 之间所有的闰年
	public static void main4(String[] args) {
		int year = 0;
		int count = 0;
		for(year = 1000; year <= 2000; year++) {
			if ((year % 4 ==0 && year % 100 != 0) ||(year % 400 == 0)) {
				System.out.println(year);
				count++;
			}
		}
		System.out.println(count);

	}
	/**
	 * 3. 打印 1 - 100 之间所有的素数
	 * @param args [description]
	 */
	public static void main3(String[] args) {
		int i = 0;
		int j = 0;
		for(i = 2; i <= 100; i++) {
			
			for (j = 2; j < i; j++) {
				if (i % j == 0) {
					break;
				} 
			}
			if(j >= i) {
				System.out.println(i);
			}

		}
		
	}
	/**
	 *  2. 判定一个数字是否是素数
	 * @param args [description]
	 */
	public static void main2(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int num = sc.nextInt();
		int i = 0;
		for(i = 2; i <= num/2; i++) {
		//for(i = 2; i <= (int)Math.sqrt(n); i++)
			if(num % i == 0) {
				System.out.println(num + "不是素数");
				break;
			}

		}
		/*for(i = 2; i < num; i++) {
			if(num % i == 0) {
				System.out.println(num + "不是素数");
				break;
			}

		}	*/
		if(i > num/2) {
			System.out.println(num + "是素数");
		} 
	}
	public static void mainp(String[] args) {
		Scanner sc = new Scanner(System.in); 
		double sum = 0.0; 
		int num = 0; 
		while (sc.hasNextDouble()) { 
			 double tmp = sc.nextDouble(); 
			 sum += tmp; 
			 num++; 
		} 
		System.out.println("sum = " + sum); 
		System.out.println("avg = " + sum / num); 
		sc.close();
	}


	public static void main1(String[] args) {
		/**
		 * 1. 根据年龄, 来打印出当前年龄的人是
		 * 少年(低于18), 青年(19-28), 中年(29-55), 老年(56以上)
		 */
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n <= 18) {
			System.out.println("少年");
		} else if(n <= 28) {
			System.out.println("青年");
		} else if(n <= 55) {
			System.out.println("中年");
		} else {
			System.out.println("老年");
		}
	}
}

