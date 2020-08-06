//木棒拼图
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int[][] op = new int[n][2];
			for (int i = 0; i < n; i++) {
				op[i][0] = scanner.nextInt();
				op[i][1] = scanner.nextInt();
			}
			stickPuzzle(n, op);
		}
	}

	public static void stickPuzzle(int n, int[][] op) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			if (op[i][0] == 1) {
				list.add(op[i][1]);
			} else {
			//不等于1移除
				list.remove(new Integer(op[i][1]));
			}
			if (canFormPoly(list)) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
	}
	//判断能否构成多边形
	//list：各边长
	public static boolean canFormPoly(ArrayList<Integer> list) {
		int len = list.size();
		for (int i = 0; i < len; i++) {
			int temp = list.remove(i);
			int sum = 0;
			for (int j = 0; j < len - 1; j++) {
				sum += list.get(j);
			}
			if (sum <= temp) { //判断是否任意len-1条边之和大于剩余一条边
				list.add(i, temp);
				return false;
			}
			list.add(i, temp);
		}
		return true;
	}
}



//地下迷宫

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static int n, m, maxRemainEnergy = 0;
	static int[][] map;
	static boolean flag = false;
	static String path = "";
	static LinkedList<String> linkedlist = new LinkedList<>();

	public static void main(String[] args) {
		//输入
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int P = sc.nextInt();
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		//处理
		runMap(0, 0, P);
		//输出
		if (!flag)
			System.out.println("Can not escape!");
		else
			System.out.println(path);
	}

	public static void runMap(int x, int y, int energy) {
		if (energy < 0 || x<0 || y<0 || x>=n || y>= m || map[x][y] != 1) return;
			else {
			linkedlist.offer("[" + x + "," + y + "]");
			map[x][y] = 0;
			if (x == 0 && y == m - 1) {
				if (energy >= maxRemainEnergy) {
					maxRemainEnergy = energy;
					updatePath();
				}
				map[x][y] = 1; linkedlist.removeLast();
				flag = true; return;
			}
			runMap(x, y+1, energy-1);
			runMap(x+1, y, energy);
			runMap(x-1, y, energy-3);
			runMap(x, y-1, energy-1);
			map[x][y] = 1;linkedlist.removeLast();
		}
	}

	public static void updatePath() {
		StringBuilder sb = new StringBuilder();
		Iterator<String> iterator = linkedlist.iterator();
		while (iterator.hasNext())
		sb.append(iterator.next() + ",");
		if (sb.length() > 0)
		sb.deleteCharAt(sb.length() - 1);
		path = sb.toString();
	}
}