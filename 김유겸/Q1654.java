package winter2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1654 {
    static long high, low;
    static int N, K;

    static void solution(long[] lan) {
        long mid = 0;
        while (low <= high) {
            mid = (high + low) / 2;
            if (cuttingLanNum(mid, lan) >= N) {
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }
        System.out.println(high);

    }

    static long cuttingLanNum(long mid, long[] lan) {
        long count = 0;
        for (int i = 0; i < K; i++) {
            count += (lan[i] / mid);
        }
        return count;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        long[] lan = new long[K];

        for (int i = 0; i < K; i++) {
            lan[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lan);

        high = lan[K - 1];
        low = 1;

        solution(lan);
    }
}
