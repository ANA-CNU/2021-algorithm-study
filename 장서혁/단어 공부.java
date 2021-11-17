import java.util.*;

enum Alphabet {A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z};

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine().toUpperCase();  // 모두 대문자로 변환
        String[] alpha = word.split("");

        int[] count = new int[26];
        for(String al : alpha) {
            count[Alphabet.valueOf(al).ordinal()]++;
        }

        int[] max = Arrays.copyOf(count, count.length);  // 배열 복사

        Arrays.sort(count);  // 오름차순 정렬

        if(count[25] == count[24]) {
            System.out.println("?");
        } else {
            Alphabet[] AlArr = Alphabet.values();
            int index = 0;
            for(int i=0 ; i < max.length ; i++) {  // 가장 큰 값의 index 찾기
                if(max[i] == count[25]) {
                    index = i;
                }
            }
            System.out.println(AlArr[index]);
        }
    }
}