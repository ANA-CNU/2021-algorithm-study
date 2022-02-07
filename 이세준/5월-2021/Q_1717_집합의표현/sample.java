package Q_1717_집합의표현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class sample {
	static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        makeSet(n);

        for(int i = 0; i < m; i ++){
            st = new StringTokenizer(br.readLine());
            int san = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(san == 0){
                merge(a, b);
            } else if(san == 1) {
                a = find(a);
                b = find(b);
                if(a == b){
                    bw.write("YES\n");
                } else {
                    bw.write("NO\n");
                }
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
    public static void makeSet(int n){
        parent = new int[n + 1];
        for(int i = 0; i <= n; i++){
            parent[i] = i;
        }
    }
    public static void merge(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b) {
			return;
		}
		parent[a] = b;
	}
	public static int find(int a) {
		if (a == parent[a]) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}

}