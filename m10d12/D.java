import java.util.*;
import java.io.*;

public class D {
    
    public static int f(int x) {
        int ans = 0;
        while (x > 0) {
            ans += x % 10;
            x /= 10;
        }
        return ans;
    }

    public static void main(String []s) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        while (true) {
            in.nextToken(); int x = (int) in.nval;
            if (x == 0) break;
            
            out.print(f(x) + " ");
        }

        out.flush();
        out.close();
        br.close();
    }
}
