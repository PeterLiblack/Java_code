package user;

import book.BookList;
import operation.IOperation;

/**
 * @Author Li_ZW
 * @Date: 2020/05/03
 * @Time: 12:16
 * @Description
 */
public abstract class User {
    protected String name;
    protected IOperation[] operations;

    public User(String name) {
        this.name = name;
    }

    public abstract int menu();

    public void doOperation(BookList bookList,int choice) {
        this.operations[choice].work(bookList);
    }
}
