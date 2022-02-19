import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Main_1235 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        HashSet<String> studentID = new HashSet<>();
        HashSet<String> newStudentID = new HashSet<>();
        int k = 1;

        for (int i = 0; i < num; i++) {
            studentID.add(sc.next());
        }

        while (true) {
            if (studentID.size() == newStudentID.size()) {
                break;
            }

            Iterator it = studentID.iterator();
            while (it.hasNext()) {
                String[] separated = String.valueOf(it.next()).split("");
                String created = "";
                for (int i = 0; i < k; i++) {
                    created = separated[separated.length - 1 - i] + created;
                }

                if (newStudentID.contains(created)) {
                    newStudentID.clear();
                    k++;
                    break;
                } else {
                    newStudentID.add(created);
                }
            }
        }

        System.out.println(k);
    }
}
