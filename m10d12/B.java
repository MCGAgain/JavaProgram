
import java.util.*;
import java.io.*;

public class B {

    public static long factor(long x) {
        long ans = 1;
        while (x > 0) ans *= x--;
        return ans;
    }

    public static void main(String []s) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        int t = 3;
        while (t-- > 0) {
            in.nextToken(); long x = (long) in.nval;
            out.print(factor(x) + " ");
        }
        out.flush();
    }
}