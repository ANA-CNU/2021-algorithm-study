import java.util.*;

public class list_23056 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<String[]> list1 = new ArrayList<String[]>();
        ArrayList<String[]> list2 = new ArrayList<String[]>();

        loop1 : while(true) {
            int c = sc.nextInt();
            String name = sc.next();

            if (c == 0 && Integer.parseInt(name) == 0) break;
            if (c > n) continue;

            int cnt = 0;
            if (c % 2 != 0) {
                for (String[] s : list1) {
                    if (s[0].equals(String.valueOf(c))) {
                        if (s[1].equals(name)) continue loop1;
                        cnt++;
                    }
                    if (cnt >= m) continue loop1;
                }

                list1.add(new String[]{String.valueOf(c), name});
            } else {
                for (String[] s : list2) {
                    if (s[0].equals(String.valueOf(c))) {
                        if (s[1].equals(name)) continue loop1;
                        cnt++;
                    }
                    if (cnt >= m) continue loop1;
                }

                list2.add(new String[]{String.valueOf(c), name});
            }
        }

        list1.sort(new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (Integer.parseInt(o1[0]) == Integer.parseInt(o2[0])) {
                    if (o1[1].length() == o2[1].length())
                        return o1[1].compareTo(o2[1]);
                    else
                        return o1[1].length() - o2[1].length();

//                    if (o1[1].length() < o2[1].length()) {
//                        return -1;
//                    } else if (o1[1].length() == o2[1].length()) {
//                        return o1[1].compareTo(o2[1]);
//                    }
                }
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            }
        });
        list2.sort(new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (Integer.parseInt(o1[0]) == Integer.parseInt(o2[0])) {
                    if (o1[1].length() == o2[1].length())
                        return o1[1].compareTo(o2[1]);
                    else
                        return o1[1].length() - o2[1].length();

//                    if (o1[1].length() < o2[1].length()) {
//                        return -1;
//                    } else if (o1[1].length() == o2[1].length()) {
//                        return o1[1].compareTo(o2[1]);
//                    }
                }
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            }
        });

        for (String[] val : list1) {
            System.out.println(val[0] + " " + val[1]);
        }
        for (String[] val : list2) {
            System.out.println(val[0] + " " + val[1]);
        }
    }
}