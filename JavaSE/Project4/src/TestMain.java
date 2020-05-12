import book.BookList;
import user.Admin;
import user.NormalUser;
import user.User;

import java.util.Scanner;

/**
 * @Author Li_ZW
 * @Date: 2020/05/03
 * @Time: 11:13
 * @Description
 * 图书管理系统
 */

public class TestMain {

    public static User login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的姓名：");
        String name = scanner.nextLine();
        System.out.println("请选择你的身份：1，管理员；2，普通用户");
        int choice = scanner.nextInt();
        if (choice == 1) {
            return new Admin(name);
        }else {
            return new NormalUser(name);
        }
    }

    public static void main(String[] args) {
        BookList bookList = new BookList();
        User user = login();

        while (true) {
            int choice = user.menu();
            user.doOperation(bookList,choice);
        }
    }
}
