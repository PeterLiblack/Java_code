/**
 * @Author Li_ZW
 * @Date: 2020/05/11
 * @Time: 15:51
 * @Description
 *
 * <T>:只是一个占位符，表示当前类是一个泛型
 * 泛型意义：
 * 1，可以自动进行类型的检查
 * 2，可以自动进行类型的转换
 *
 * 注意：
 * 1，不能new泛型类型的数组
 * 2，简单类型不能作为泛型的参数
 */

public class TestMain2<T> {
    public T[] elem;
    public int usedSize;
    public TestMain2() {
      this.elem = (T[])new Object[10];
      this.usedSize = 0;
    }

    //默认放到数组最后
    public void add(T val) {
        this.elem[this.usedSize] = val;
        this.usedSize++;
    }

    public T getVal(int pos) {
        return this.elem[pos];
    }
}
