// 百万富翁问题
import java.lang.Math;
public class Main{
  public static void main(String[] args){
    long sumRich = 30 * 10;
    long sumStranger = (1L << 30) - 1;
    System.out.print(sumRich + " " + sumStranger);
 }
}



//风口的猪-中国牛市
public class Solution {
	public static int calculateMax(int[] prices) {
         int firstBuy = Integer.MAX_VALUE;  // 第一次买入最好的价格，越低越好
         int firstSell = 0;          // 第一次卖出后的最高收益，越高越好
         int secondBuy = Integer.MIN_VALUE; // 第二次买入时还剩余的最高收益，越高越好
         int secondSell = 0;         // 第二次卖出时总的最高收益，越高越好
    for (int price : prices) {
         // 当前价格下第一次买入的价格
         firstBuy = Math.min(firstBuy, price);
		// 当前价格 - 买入价格 就是当前价格下第一次买卖的收益
         firstSell = Math.max(firstSell, price - firstBuy);
    // 第一次卖出的收益 - 当前价格，即当前价格下，第二次买入后还剩余收益
         secondBuy = Math.max(secondBuy, firstSell - price);
    // 剩余收益 + 当前价格，即当前价格下，第二次买卖的收益
		secondSell = Math.max(secondSell, secondBuy + price);
	}
	return secondSell;
	}
}