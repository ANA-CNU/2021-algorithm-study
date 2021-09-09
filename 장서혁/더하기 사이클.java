import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(cycle(n));
    }
    static int cycle(int x) {
        int n = x;
        int i = 0;
        while (true) {
            int a = 0;
            int x1 = x / 10;
            int x2 = x - (x1 * 10);
            if (x1 + x2 < 10) {
                a = (x2 * 10) + (x1 + x2);
            } else {
                a = (x2 * 10) + (x1 + x2) - 10;
            }
            x = a;
            i++;
            if (a == n) break;
        }
        return i;
    }
}
