package operation;

import book.BookList;

/**
 * @Author Li_ZW
 * @Date: 2020/05/03
 * @Time: 11:36
 * @Description
 * 退出系统
 */
public class ExitOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("退出系统");
        System.exit(1);
    }
}
