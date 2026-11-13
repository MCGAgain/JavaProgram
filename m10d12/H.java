import java.util.*;
import java.io.*;

public class H {


    public static void main(String []s) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        in.nextToken(); int n = (int) in.nval;
        int[] a = new int[n + 10];
        int oddcount = 0, evencount = 0, oddsum = 0, evensum = 0;

        for (int i = 0; i < n; i++) {
            in.nextToken(); a[i] = (int) in.nval;
            if ((a[i] & 1) == 1) {
                oddcount++;
                out.print(a[i] + " ");
            }
            else {
                evencount++;
            }
        }
        out.println();
        out.printf("oddcount=%d evencount=%d\n", oddcount, evencount);
        
        for (int i = 0; i < n; i += 2) {
            out.print(a[i] + " ");
            oddsum += a[i];
        }
        out.println("sum=" + oddsum);

        for (int i = 1; i < n; i += 2) {
            out.print(a[i] + " ");
            evensum += a[i];
        }
        out.println("sum=" + evensum);        


        out.flush();
        out.close();
        br.close();
    }
}
