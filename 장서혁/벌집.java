import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(bee(n, 0));

    }

    static int bee(int n, int i) {
        if(n==1) return 1;
        else if(n >= 2 + 6 * ( i*(i+1) / 2 ) && n <= 7 +  6 * ( i*(i+3) / 2 )) {  // 계차수열 일반항 이용
            return i + 2;
        }
        else {
            i += 1;
            return bee(n, i);
        }
    }
}
