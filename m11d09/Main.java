package m11d09;

import java.util.*;
 
class Pair implements Comparable<Pair> {
    public int w, n;
    
    public Pair(int w, int n) {
        this.w = w;
        this.n = n;
    }

    public int compareTo(Pair o) {
        return o.w - w;
    }
}
 
public class Main {
 
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int idx = 0;
        int[] a = new int[210];
         
        while (sc.hasNextInt()) {
            a[idx++] = sc.nextInt();
        }
         
        int n = idx / 2;
         
        Pair[] cash = new Pair[n + 10];
         
        for (int i = 0; i < n; i++) {
            cash[i] = new Pair(a[i], a[i + n]);
        }
         
        int goal = a[idx - 1];
        Arrays.sort(cash, 0, n);
         
        int ans = 0;
         
        for (int i = 0; i < n; i++) {
            int weight = cash[i].w, num = cash[i].n;

            int take = Math.min(num, goal / weight);
            goal -= take * weight;
            ans += take;
            if (goal == 0) break;
        }
         
         
        System.out.println(ans);
    }
 
}