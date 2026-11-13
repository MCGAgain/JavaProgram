import java.util.*;
public class B {
    public static void main(String S[]) {
        Scanner cin = new Scanner(System.in);
        StringBuilder ans = new StringBuilder(), odd = new StringBuilder(), even = new StringBuilder();
        int n = cin.nextInt(), oddCnt = 0, evenCnt = 0;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = cin.nextInt();
            if ((a[i] & 1) == 1) {
                ans.append(a[i]).append(' ');
                oddCnt++;
            }
            else evenCnt++;
        }
        ans.append('\n');
        ans.append("oddcount=").append(oddCnt).append(" evencount=").append(evenCnt).append('\n');
        Arrays.sort(a);
        int oddSum = 0, evenSum = 0;
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                oddSum += a[i];
                odd.append(a[i]).append(' ');
            }
            else {
                evenSum += a[i];
                even.append(a[i]).append(' ');
            }
        }
        odd.append("sum=").append(oddSum).append('\n');
        even.append("sum=").append(evenSum).append('\n');
        ans.append(odd).append(even);
        System.out.print(ans);
    }
}
