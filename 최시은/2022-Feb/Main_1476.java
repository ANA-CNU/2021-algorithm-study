import java.util.Scanner;

public class Main_1476 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        int input_E = Integer.parseInt(input.split(" ")[0]);
        int input_S = Integer.parseInt(input.split(" ")[1]);
        int input_M = Integer.parseInt(input.split(" ")[2]);

        int E = 1;
        int S = 1;
        int M = 1;
        int year = 1;

        while (true) {
            if (input_E == E && input_S == S && input_M == M) {
                break;
            }

            E++;
            S++;
            M++;
            year++;

            if (E == 16) {
                E = 1;
            }

            if (S == 29) {
                S = 1;
            }

            if (M == 20) {
                M = 1;
            }
        }

        System.out.println(year);
    }
}
