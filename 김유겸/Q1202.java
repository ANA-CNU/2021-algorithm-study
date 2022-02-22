package winter2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Jewel implements Comparable<Jewel> {
    int weight;
    int price;

    public Jewel(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    @Override
    public int compareTo(Jewel o) {//보석의 무게는 작은거부터 무게가 같을 때는 비싼 순으로 정렬
        return this.weight - o.weight;
    }
}

public class Q1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Jewel> jewels = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            jewels.add(new Jewel(weight, price));
        }
        Collections.sort(jewels);

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);

        PriorityQueue<Integer> pQ = new PriorityQueue<>(Comparator.reverseOrder());

        long answer = 0;
        int i = 0;
        for (int bag : bags) {
            for (; i < jewels.size(); i++) {
                if (bag >= jewels.get(i).weight) {
                    pQ.offer(jewels.get(i).price);
                } else {
                    break;
                }
            }
            if (!pQ.isEmpty()) {
                answer += pQ.poll();
            }
        }
        System.out.println(answer);

    }
}
