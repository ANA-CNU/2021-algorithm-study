import java.util.*;

public class Main_1037 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Long> numbers = new ArrayList<>();
        String[] input = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            long number = Integer.parseInt(input[i]);
            numbers.add(number);
        }
        Collections.sort(numbers);
        int size = numbers.size();

        long result = numbers.get(0) * numbers.get(size - 1);
        System.out.println(result);
    }
}
