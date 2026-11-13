import java.util.*;
import java.io.*;

public class Test1 {

    static boolean isPrime(int x) {
        if (x < 2) return false;
        for (int i = 2; i <= x / i; i ++) if (x % i == 0) return false;
        return true;
    }

    static boolean isPal(int x) {
        int[] s = new int[10];
        int len = 0;

        while (x > 0) {
            s[len++] = x % 10;
            x /= 10;
        }

        int l = 0, r = len - 1;
        while (l < r) {
            if (s[l] != s[r]) return false;
            l++; r--;
        }
        return true;
    }

    public static void main(String[] s) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        while (true) {
            in.nextToken(); int l = (int) in.nval;
            in.nextToken(); int r = (int) in.nval;
            if (l == 0 && r == 0) break; 
            int count = 0, first = 0, last = 0;

            for (int i = l; i <= r; i++) {
                if (isPal(i) && isPrime(i)) {
                    count++;
                    if (count == 1) first = i;
                    last = i;
                }
            }
            
            if (count == 0) out.println("0 -1 -1");
            else out.println(count + " " + first + " " + last);
        }   
        out.flush();
    }
}
