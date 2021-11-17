import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int i = 1;  // 지그재그 대각선 줄
        int a = 0;
        int b = 0;

        while(true) {
            if(x > i) {
                x -= i;
            } else {
                a = x;
                b = (i+1) - a;
                if(i % 2 == 0) {  // 짝수 줄
                    a = x;
                    b = (i+1) - a;
                } else {          // 홀수 줄
                    b = x;
                    a = (i+1) - b;
                }
                break;
            }
            i++;
        }
        System.out.println(a + "/" + b);
    }
}