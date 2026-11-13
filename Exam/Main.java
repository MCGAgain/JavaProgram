import java.util.*;
import java.io.*;
 
public class Main {
     
    public static int getLen(int x) {
        int ans = 0;
        while (x > 0) {
            ans++;
            x /= 10;
        }
        return ans;
    }
     
    public static boolean judge(int x) {
        int[] a = new int[10];
        int cnt = 0;
         
        while (x > 0) {
            a[cnt++] = x % 10;
            x /= 10;
        }
         
        int l = 0, r = cnt - 1;
         
        while (l < r) {
             
            if (a[l] != a[r]) return false;
             
            l++; r--;
        }
             
     
        return true;
    }
     
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder ans = new StringBuilder();
        int N = (int)(4e6 + 10), n = (int)(4e6 + 5);
         
        boolean[] st = new boolean[N];
        for (int i = 0; i <= n; i++) st[i] = false;
        int[] prime = new int[N];
        int[] res = new int[N];
        int cnt = 0, rescnt = 0;
         
        for (int i = 2; i <= n; i++) {
            if (st[i] == false) prime[cnt++] = i;
             
            for (int j = 0; j < cnt && prime[j] <= n / i; j++) {
                st[prime[j] * i] = true;
                if (i % prime[j] == 0) break;
            }
        }
         
        st[0] = true;
        st[1] = true;
         
        while (true) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            rescnt = 0;
             
            if (l == 0 && r == 0) break;
             
            for (int i = l; i <= r; i++) {
                if (st[i] == false && judge(i)) {
                    res[rescnt++] = i;
                    //System.out.println(i);
                }
            }
            if (rescnt > 0) System.out.println(rescnt + " " + res[0] + " " + res[rescnt - 1]);
            else System.out.println("0 -1 -1");
        }
         
    }
 
}