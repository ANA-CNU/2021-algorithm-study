import java.util.*;
import java.io.*;

public class N_15651 {
	public static StringBuilder sb = new StringBuilder();
	public static int[] arr;
	public static void dfs(int d, int N, int M){
		if(d==M){
			for(int i = 0; i<M; i++){
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 1; i<=N; i++){
			arr[d] = i;
			dfs(d+1,N,M);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		arr = new int[M];
		dfs(0,N,M);
		System.out.println(sb.toString());

	}

}