package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * @Author Li_ZW
 * @Date: 2020/05/03
 * @Time: 11:36
 * @Description
 * 打印书单
 */
public class DisplayOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("打印书单");

        for (int i = 0; i < bookList.getUsedSize(); i++) {
            Book book = bookList.getBooks(i);
            System.out.println(book);
        }
    }
}
