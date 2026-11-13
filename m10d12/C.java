import java.util.*;
import java.io.*;

public class C {
    
    public static void main(String []s) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        int a, b;

        while (true) {

            in.nextToken(); a = (int) in.nval;
            if (a < 0) break;
            in.nextToken(); b = (int) in.nval;

            for (int i = 0; i < b; i++) out.printf("%c", a + i);
            out.println("");
        }

        out.flush();
        // out.close();
        // br.close();
    }
}
