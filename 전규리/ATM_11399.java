import java.util.*;
public class ATM_11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= len; i++) {
            int v = sc.nextInt();
            list.add(v);
        }

        Collections.sort(list);

        int total = 0;
        int tmp = 0;
        for (int i = 0; i < len; i++) {
            total += tmp + list.get(i);
            tmp += list.get(i);
        }

        System.out.println(total);
    }
}
