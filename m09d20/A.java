
import java.util.*;

public class A {
    static public String toSeason(int month) {
        if (month < 1 || month > 12) return "月份有误：重新输入。";
        else if (month >= 6 && month <= 8) return "夏季";
        else if (month >= 9 && month <= 11) return "秋季";
        else if (month >= 3 && month <= 5) return "春季";
        else return "冬季";
    }
    public static void main(String s[]) {
        for (int i = 0; i <= 13; i++) {
            System.out.println(i + "月：" + toSeason(i));
        }
    }    
}
