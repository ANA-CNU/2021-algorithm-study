import java.util.*;

public class Main_2675 {
    public static void main(String[] args) {
        String[] alphanumeric = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
                "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "\\", "$",
                "%", "*", "+", "-", ".", "/", ":"};

        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < num; i++) {
            String input = sc.nextLine();
            int rp = Integer.parseInt(input.split(" ")[0]);
            String[] words = input.split(" ")[1].split("");


            String judge = "";
            boolean YES = false;
            boolean isAlphanumeric = false;

            for (String word : words) {
                 for (String s : alphanumeric) {
                    if (word.equals(s)) {
                        judge += "1";
                        YES = true;
                        break;
                    }
                 }
                 if (!YES) {
                     judge += "0";
                 } else {
                     YES = !YES;
                 }
            }

            if (!judge.contains("0")) {
                isAlphanumeric = true;
            }

            String result = "";
            if (isAlphanumeric) {
                for (String word : words) {
                    for (int j = 0; j < rp; j++) {
                        result += word;
                    }
                }
            }
            System.out.println(result);

        }
    }
}
