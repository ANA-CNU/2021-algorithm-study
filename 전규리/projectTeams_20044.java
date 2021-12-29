import java.util.*;

public class projectTeams_20044 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < len*2; i++) {
            list.add(sc.nextInt());
        }

        int min = 200000;

        list.sort(null);

        for (int i = 0; i < len; i++) {
            int a = list.get(i);
            int b = list.get(list.size()-i-1);
            if (min > a+b) {
                min = a+b;
            }
            min = Math.min(min, a + b);
        }

        System.out.println(min);

    }
}
