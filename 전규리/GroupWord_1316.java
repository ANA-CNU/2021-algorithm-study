import java.util.*;

public class GroupWord_1316 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();
        int cnt = len;
        loop : for (int i = 0; i < len; i++) {
            String[] tmp = sc.next().split("");

            int chk[] = new int[26];
            chk[tmp[0].charAt(0)-97] += 1;
            for (int j = 1; j < tmp.length; j++) {
                chk[tmp[j].charAt(0)-97] += 1;

                if (chk[tmp[j].charAt(0)-97] > 1 && !tmp[j].equals(tmp[j-1])) {
                    cnt--;
                    continue loop;
                }
            }
        }

        System.out.println(cnt);
    }
}
