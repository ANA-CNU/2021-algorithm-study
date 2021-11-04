import java.util.*;

public class Main_1181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        HashSet<String> hashSet = new HashSet<String>();
        for (int i = 0; i < n; i++) {
            String input = sc.next();
            hashSet.add(input);
        }
        List<String> list = new ArrayList<>(hashSet);
        Collections.sort(list);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });

        int size = list.size();

        for (int i = 0; i < size; i++) {
            System.out.println(list.get(i));
        }

    }
}
