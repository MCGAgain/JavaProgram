import java.util.*;
public class Std {

    static boolean isPrime(int x) {
        if (x < 2) return false;
        for (int i = 2; i <= x / i; i++) if (x % i == 0) return false;
        return true;
    }

    public static void main(String[] s) {
        Scanner cin = new Scanner(System.in);
        int l = cin.nextInt(), r = cin.nextInt();
        long cnt = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = l; i <= r; i++) {
            if (isPrime(i)) {
                ans.append(i).append(' ');
                cnt++;
            }
        }
        System.out.println(ans);
        System.out.println(cnt);
    }    
}
 