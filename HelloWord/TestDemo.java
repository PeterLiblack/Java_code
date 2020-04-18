import java.util.Scanner;
import java.util.Random; 

public class TestDemo {
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



	public static void main2(String[] args) {
		Scanner sc = new Scanner(System.in); 
		System.out.println("请输入你的姓名："); 
		String name = sc.nextLine(); 
		System.out.println("请输入你的年龄："); 
		int age = sc.nextInt(); 
		System.out.println("请输入你的工资："); 
		float salary = sc.nextFloat(); 
		System.out.println("你的信息如下："); 
		System.out.println("姓名: "+name+"\n"+"年龄："+age+"\n"+"工资："+salary); 
		sc.close();
	}

	public static void main1(String[] args) {
		//Scanner scan = new Scanner(System.in);

		//int num = scan.nextInt();
		int num = 100; 
		while (num <= 200) { 
			 if (num % 3 == 0) { 
				 System.out.println("找到了 3 的倍数, 为:" + num); 
				 //break; 
		 } 
		 num++; 
		}
	}
}