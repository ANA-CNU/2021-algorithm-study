import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder bw = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] S = new int[N + 1];
        int[] P = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
            P[S[i]] = i;
        }
        FenwickTree t = new FenwickTree(N);
        long ret = 0;
        for (int i = N; i >= 1; i--) {
            ret += t.sum(P[i]);
            t.add(P[i], 1);
        }
        bw.append(ret).append("\n");
        System.out.print(bw);
    }

}
class FenwickTree {
    int[] tree;

    FenwickTree(int n) {
        tree = new int[n + 1];
    }

    void add(int pos, int val) {
        while (pos < tree.length) {
            tree[pos] += val;
            pos += (pos & -pos);
        }
    }

    int sum(int pos) {
        int ret = 0;
        while (pos > 0) {
            ret += tree[pos];
            pos -= (pos & -pos);
        }
        return ret;
    }
    
}
