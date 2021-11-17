import java.util.*;

public class Main_2750 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        HashSet<Integer> numbers = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
            numbers.add(input);
        }
        List<Integer> sorted = new LinkedList<>(numbers);
        Collections.sort(sorted);
        int size = sorted.size();
        for (int i = 0; i < size; i++) {
            System.out.println(sorted.get(i));
        }
    }
}
