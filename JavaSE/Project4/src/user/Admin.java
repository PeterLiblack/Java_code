package user;

import operation.*;

import java.util.Scanner;

/**
 * @Author Li_ZW
 * @Date: 2020/05/03
 * @Time: 12:16
 * @Description
 * 管理者
 */
public class Admin extends User {

    public Admin(String name) {
        super(name);
        this.operations = new IOperation[] {
                new ExitOperation(),
                new FindOperation(),
                new AddOperation(),
                new DelOperation(),
                new DisplayOperation()
        };
    }

    @Override
    public int menu() {
        System.out.println("=======================");
        System.out.println("hello " + this.name + "欢迎来到图书管理系统");
        System.out.println("====== 1，查找图书 ======");
        System.out.println("====== 2，新增图书 ======");
        System.out.println("====== 3，删除图书 ======");
        System.out.println("====== 4，打印书单 ======");
        System.out.println("====== 0，退出系统 ======");
        System.out.println("=======================");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        return choice;
    }
}
