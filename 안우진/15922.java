// BOJ 15922

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] c = new int[N][2];

        for(int i=0; i<N; i++) {
            String[] tmp = br.readLine().split(" ");
            c[i][0] = Integer.parseInt(tmp[0]);
            c[i][1] = Integer.parseInt(tmp[1]);
        }
        int last = Integer.MIN_VALUE;
        int ans = 0;
        for(int[] a : c) {
            if(a[0] >= last){
                ans+=a[1]-a[0];
            }else{
                if(a[1] < last) continue;
                ans+=a[1]-last;
            }
            last=a[1];

        }
        System.out.println(ans);
    }
}
