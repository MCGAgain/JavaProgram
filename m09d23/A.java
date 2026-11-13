
import java.util.*;

public class A {

    static int n;

    public static void dispaly(int len) {
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int l = (len - i * 2 + 1) / 2, r = (len - i * 2) / 2;
            while (l-- > 0) ans.append('-');
            for (int j = 1; j <= i; j++) ans.append(i).append('-');
            while (r-- > 0) ans.append('-'); 
            ans.append('\n');
        }
        System.out.print(ans);
    }

    public static void main(String s[]) {
        Scanner cin = new Scanner(System.in);
        while ((n = cin.nextInt()) != 0) dispaly(2 * n + 1);
    } 
}
