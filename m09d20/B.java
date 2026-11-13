
import java.util.*;

public class B {
    static public String toSeason(int month) {
        if (month < 1 || month > 12) return "月份有误：重新输入。";
        switch (month) {
            case 12: case 1: case 2:
                return "冬季";
            case 3: case 4: case 5:
                return "春季";
            case 6: case 7: case 8:
                return "夏季";
            case 9: case 10: case 11:
                return "秋季";
        }
        return "";
    }
    public static void main(String s[]) {
        for (int i = 0; i <= 13; i++) {
            System.out.println(i + "月：" + toSeason(i));
        }
    }    
}
