import java.util.Scanner;
public class Main {
    public static void main(String s[]) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextLine()) {
            String a = cin.nextLine();
            System.out.println("Hello," + a);
        }

        cin.close();
    }
}
