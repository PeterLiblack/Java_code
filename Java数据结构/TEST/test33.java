//字符串替换
import java.util.*;

public class Main {
    public String replace(String s,String s1,String s2) {
        StringBuffer sb = new StringBuffer();
        for(int i=0; i < s.length(); i++) {
            boolean finded = false;
            for(int j=0; j < s1.length(); j++) {
                if(s.charAt(i+j)!=s1.charAt(j)) {
                    break;
                }else if(s.charAt(i+j)==s1.charAt(j)&&j==s1.length()-1) {
                    i += j;
                    finded = true;
                    sb.append(s2);
                }
            }
            if(!finded) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        Main sc = new Main();
        String str = sc.replace("abcdef","bc","de");
        System.out.println(str);
    }
}