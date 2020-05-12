package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * @Author Li_ZW
 * @Date: 2020/05/03
 * @Time: 11:37
 * @Description
 * 查找图书
 */
public class FindOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("查找图书");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入图书的名字：");
        String name = scanner.nextLine();

        for (int i = 0; i < bookList.getUsedSize(); i++) {
            Book book = bookList.getBooks(i);
            if (book.getName().equals(name)) {
                System.out.println(book);
                System.out.println("查找成功！");
                return;
            }
        }
    }
}
