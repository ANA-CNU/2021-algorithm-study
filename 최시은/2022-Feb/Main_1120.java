import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main_1120 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        ArrayList<String> A = new ArrayList<>(Arrays.asList((input.split(" ")[0]).split("")));
        ArrayList<String> B = new ArrayList<>(Arrays.asList((input.split(" ")[1]).split("")));
        int cycle = B.size() - A.size() + 1;
        ArrayList<Integer> counts = new ArrayList<Integer>();

        while (A.size() != B.size()) {
            A.add("!");
        }

        for (int i = 0; i < cycle; i++) {
            int count = 0;
            for (int j = 0; j < B.size(); j++) {
                if (!(A.get(j).equals("!") || A.get(j).equals(B.get(j)))) {
                    count++;
                }
            }
            counts.add(count);
            A.remove(A.size() - 1);
            A.add(0, "!");
        }

        Collections.sort(counts);
        System.out.println(counts.get(0));

    }
}
