// 字母统计
import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      int[] count = new int[26]; // 因为只有 26 个英文字母，所以只需要 26 长度
      for (int i = 0; i < line.length(); i++) {
        char ch = line.charAt(i);
        if (ch >= 'A' && ch <= 'Z') {
// 哈希中的直接定址法
          count[ch - 'A']++;
       }
     }
      for (int i = 0; i < 26; i++) {
        System.out.printf("%c:%d%n", ('A' + i), count[i]);
     }
   }
 }
}


// 进制转换
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      long num = 0;
      for (int i = 2; i < line.length(); i++) {
        num *= 16;
        char ch = line.charAt(i);
        int n = 0;
        if (ch >= 'A' && ch <= 'F') {
          n = ch - 'A' + 10;
       } else if (ch >= 'a' && ch <= 'f') {
          n = ch - 'a' + 10;
       } else {
          n = ch - '0';
       }
        num += n;
     }
      System.out.println(num);
   }
 }
}