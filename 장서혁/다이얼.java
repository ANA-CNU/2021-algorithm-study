import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] alpha = {"", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};

        String s = sc.next();

        int sum = 0;
        for(int i=2 ; i<alpha.length ; i++) {                // 문자열이랑 알파벳이랑 비교하여 같으면 더하기
            for(int j=0 ; j<s.length() ; j++) {
                for(int k=0 ; k<alpha[i].length() ; k++) {
                    if(s.charAt(j)== alpha[i].charAt(k)) {
                        sum += i+1;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}