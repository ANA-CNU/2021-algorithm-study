import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] num = new String[2];

        for(int i=0 ; i<2 ; i++) {            // 두 수를 거꾸로 바꾸고 num 배열에 저장
            String s = sc.next();
            String[] arr = s.split("");
            String tmp = arr[0];
            arr[0] = arr[2];
            arr[2] = tmp;
            num[i] = arr[0] + arr[1] + arr[2];
        }

        if(Integer.parseInt(num[0]) > Integer.parseInt(num[1])) {  // num 배열 중 큰 수 출력
            System.out.println(num[0]);
        }
        else {
            System.out.println(num[1]);
        }
    }
}