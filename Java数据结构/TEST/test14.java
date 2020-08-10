//Broken Keyboard
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String originalString = scanner.next();
		String typedOutString = scanner.next();
		ArrayList<Character> wornOutKeys = new ArrayList<>();
		int size = originalString.length();
		int iOriginal = 0;
		int iTypedOut = 0;
		while (iOriginal < size) {
			boolean wornOut = false; // 假设没有损坏
			char originalCh = originalString.charAt(iOriginal);
			char originalUpper = Character.toUpperCase(originalCh); // 全部大写
			if (iTypedOut >= typedOutString.length()) {
				// 输出的字符串已经结束了
				wornOut = true;
			} else {
				char typedOutCh = typedOutString.charAt(iTypedOut);
				char typedOutUpper = Character.toUpperCase(typedOutCh);
				if (originalUpper != typedOutUpper) {
					// 应该看到输出的字符没有输出
					wornOut = true;
				}
			}
			if (wornOut) {
				if (!wornOutKeys.contains(originalUpper)) {
					wornOutKeys.add(originalUpper);
				}
				iOriginal++;
			} else {
				iOriginal++;
				iTypedOut++;
			}
		}
		for (int i = 0; i < wornOutKeys.size(); i++) {
			System.out.print(wornOutKeys.get(i));
		}
		System.out.println();
	}
}





//球的半径和体积
import java.util.Scanner;

public class Main {
	private static class Point {
		public double x;
		public double y;
		public double z;
		Point(double x, double y, double z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	private static final double PI = Math.acos(-1);
	private static double distanceOfTwoPoint(Point a, Point b) {
		double x = Math.pow(a.x - b.x, 2);
		double y = Math.pow(a.y - b.y, 2);
		double z = Math.pow(a.z - b.z, 2);
		return Math.sqrt(x + y + z);
	}
	private static double volumeOfSphere(double r) {
		return (4.0 / 3) * PI * Math.pow(r, 3);
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			double x0 = scanner.nextDouble();
			double y0 = scanner.nextDouble();
			double z0 = scanner.nextDouble();
			Point a = new Point(x0, y0, z0);
			double x1 = scanner.nextDouble();
			double y1 = scanner.nextDouble();
			double z1 = scanner.nextDouble();
			Point b = new Point(x1, y1, z1);
			double r = distanceOfTwoPoint(a, b);
			double volume = volumeOfSphere(r);
			System.out.format("%.3f %.3f\n", r, volume);
		}
	}
}