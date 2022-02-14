package winter2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2805 {
    static int[] treeArr;
    static int  N, M;
    static long answer = Integer.MIN_VALUE;
    static void binarySearch(int mid,int lt,int rt){
        if(lt<=rt){
            long sum = 0;

            for (int i = 0; i < N; i++) {
                if (treeArr[i] > mid) {
                    sum += treeArr[i] - mid;
                }
            }

            if(sum >= M){
                answer =  Math.max(answer, mid);
                lt = mid + 1;
                mid = (rt + lt) / 2;
                binarySearch(mid, lt, rt);
            }
            else{
                rt = mid - 1;
                mid = (rt + lt) / 2;
                binarySearch(mid, lt, rt);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        treeArr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            treeArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(treeArr);

        int lt = 0;
        int rt = treeArr[N - 1];
        int mid = (lt + rt) / 2;

        binarySearch(mid,lt, rt );

        System.out.println(answer);
    }
}
