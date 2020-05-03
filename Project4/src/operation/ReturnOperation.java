package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * @Author Li_ZW
 * @Date: 2020/05/03
 * @Time: 11:37
 * @Description
 *归还图书
 */

public class ReturnOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("归还图书");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入归还图书的名字：");
        String name = scanner.nextLine();

        for (int i = 0; i < bookList.getUsedSize(); i++) {
            Book book = bookList.getBooks(i);
            if (book.getName().equals(name)) {
                book.setBorrowed(false);
                System.out.println("归还成功！");
                return;
            }
        }
    }
}
