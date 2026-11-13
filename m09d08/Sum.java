
import java.util.*;

public class Sum {
    
    static int solve(int x) {
        int sum = 0;
        while (x != 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }

    public static void main(String[] s) {

    Scanner cin = new Scanner(System.in);
    int n;

    while ((n = cin.nextInt()) != 0) System.out.printf("%d ", solve(n));

    }
}