import java.util.*;
import java.io.*;

public class E {
    
    public static boolean isPrime(int x) {
        if (x < 2) return false;
        for (int i = 2; i <= x / i; i ++) if (x % i == 0) return false;
        return true;
    }

    public static void main(String []s) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        in.nextToken(); int l = (int) in.nval;
        in.nextToken(); int r = (int) in.nval;
        int cnt = 0;

        for (int i = l; i <= r; i++) {
            if (isPrime(i)) {
                cnt++;
                out.print(i + " ");
            }
        }

        out.println("");
        out.print(cnt);

        out.flush();
        out.close();
        br.close();
    }
}
