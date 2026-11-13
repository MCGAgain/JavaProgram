
import java.util.Scanner;
public class Sum {

    public static void main(String[] args) {
        int min = (int)1e9, max = (int)-1e9;
        int sum = 0, cnt = 0;
        
        Scanner cin = new Scanner(System.in);
        int[] map = new int[110];
        int x, fail = 0;

        while ((x = cin.nextInt()) != -1) {
            if (x < 60) fail++;
            sum += x; cnt++;
            min = x < min ? x : min;
            max = x > max ? x : max;
            map[x]++;
        }

        if (cnt == 0) 
            System.out.println("avg=0.00 max=0 min=0 maxCount=0 failCount=0");
        else 
            System.out.printf("avg=%.2f max=%d min=%d maxCount=%d failCount=%d\n", (double)sum / cnt, max, min, map[max], fail);
        
    }
}
