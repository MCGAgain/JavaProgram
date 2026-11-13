
import java.util.*;
import java.io.*;

public class A {
    
    public static void main(String []s) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        out.println("Hello," + br.readLine());

        out.flush();
    }
}
