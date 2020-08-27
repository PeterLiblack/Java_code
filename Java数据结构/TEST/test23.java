//小易的升级之路
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = 0;
		int ability = 0;
		while (scan.hasNext()) {
			num = scan.nextInt(); //怪物的数量
			ability = scan.nextInt();//小易初始化技能值
			for (int i = 0; i < num; ++i) {
				int monster = scan.nextInt();
				if (monster <= ability) {//怪兽防御小于等于技能，技能加怪兽的防御值
					ability += monster;
				} else {//怪兽防御大于技能，技能加两者的最大公约数
					ability += GCD(ability, monster);
				}
			}
			System.out.println(ability);
		}
		scan.close();
	}
	/*
	辗转相除法，又名欧几里德算法，是一种非常高效的求最大公约数（GCD）的算法，它无需分解两个整数的质因
	子，辗转相除法的递推公式是GCD(a,b)==GCD(b,a%b)，当a%b==0时，b即为所求的最大公约数
	*/
	public static int GCD(int a, int b) {
		int temp;
		while (b > 0) {
			temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
}





//最高分是多少
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = 0;
		int m = 0;
		while (scanner.hasNext()) {
			n = scanner.nextInt(); //学生数量
			m = scanner.nextInt(); //老师可以操作的次数
			int[] stu = new int[n];//学生成绩
			for (int i = 0; i < n; i++) {
				stu[i] = scanner.nextInt();
			}
			//老师询问
			for (int i = 0; i < m; i++) {
				String c = scanner.next();
				int a = scanner.nextInt();
				int b = scanner.nextInt();
				if (c.equals("Q")) {
					int s = Math.min(a, b);//开始下标
					int e = Math.max(a, b);//结束下标
					int max = stu[s - 1];
					//计算出 [s-1 , e)范围的最大值
					for (int index = s; index < e; index++) {
						max = Math.max(max, stu[index]);
					}
					System.out.println(max);
				}
				if (c.equals("U")) {
					stu[a - 1] = b;
				}
			}
		}
	}
}