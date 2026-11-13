
import java.io.*;
import java.util.*;

public class GetPrime {

    static PrintWriter out = new PrintWriter(System.out);

    static int intSqrt(int x) {
        if (x <= 1) return x;
        int res = 0;
        for (int i = 1 << 15; i > 0; i >>= 1) {
            int temp = res | i;
            if (temp <= x / temp) res = temp;
        }
        return res;
    }

    static int getPrime(int[] prime, int n) {
        BitSet st = new BitSet(n);
        int cnt = 0;

        for (int i = 2; i <= n; i++) {
            if (!st.get(i)) prime[cnt++] = i;
            for (int j = 0; j < cnt && prime[j] <= n / i; j++) {
                st.set(prime[j] * i);
                if (i % prime[j] == 0) break;
            }
        }

        return cnt;
    }

    public static void main(String[] s) {
        Scanner cin = new Scanner(System.in);

        int l = cin.nextInt();

        int r = cin.nextInt();
        BitSet st = new BitSet(r - l + 10);

        int n = intSqrt(r);
        int[] prime = new int[n + 1];
        int cnt = getPrime(prime, n);

        for (int i = 0; i < cnt; i++) {
            int t = Math.max(prime[i] * prime[i], (prime[i] + l - 1) / prime[i] * prime[i]);
            for (int j = t; j <= r; j += prime[i]) st.set(j - l);
        }

        int t = 0;
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i <= r - l; i++) if (i + l >= 2 && !st.get(i)) {
            t++;
            ans.append(i + l).append(' ');
        }
        out.println(ans);
        out.println(t);
        out.flush();
    }    
}