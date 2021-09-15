import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] arr = s.split(" ");     // 문자열 공백으로 나눈 배열

        int num = 0;
        for(int i=0 ; i < arr.length ; i++) {  // 문자열 길이가 0인 배열은 제외하여 세기
            if(arr[i].length() != 0) {
                num++;
            }
        }
        System.out.println(num);
    }
}