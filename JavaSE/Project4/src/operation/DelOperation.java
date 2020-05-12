package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * @Author Li_ZW
 * @Date: 2020/05/03
 * @Time: 11:35
 * @Description
 * 删除图书
 */
public class DelOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("删除图书");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要删除图书的名字：");
        String name = scanner.nextLine();

        int i = 0;
        for (i = 0; i < bookList.getUsedSize(); i++) {
            Book book = bookList.getBooks(i);
            if (book.getName().equals(name)) {
                //查询是否有该图书
                break;
            }
        }
        if (i == bookList.getUsedSize()) {
            System.out.println("没有这本书！");
            return;
        }

        //删除
        for (int pos = 0; pos < bookList.getUsedSize() - 1; pos++) {
            Book book = bookList.getBooks(pos + 1);
            bookList.setBooks(pos, book);
        }
        bookList.setUsedSize(bookList.getUsedSize() - 1);
        System.out.println("删除成功！");
    }
}
