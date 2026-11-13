
import java.util.*;

public class Factor {
    static Scanner cin = new Scanner(System.in);

    static void solve() {
        long n = cin.nextLong(), fac = 1;
        for (long i = 2; i <= n; i++) fac *= i;
        System.out.printf("%d ", fac);
    }
    public static void main(String[] s) {
        int T = 3; while (T-- > 0) solve();
    }
}
