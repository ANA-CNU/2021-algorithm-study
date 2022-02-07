package Q_10451_순열사이클;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int arr[];
	static boolean [] v;
	

	public static void main(String args[]) throws Exception {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			int cnt =0;
			n = Integer.parseInt(br.readLine());
			String input [] = br.readLine().split(" ");
			arr = new int [n+1];
			v = new boolean [n+1];
			for(int i =1; i< arr.length;i++) {
				arr[i] = Integer.parseInt(input[i-1]);
		
			}
			for(int i =1; i< arr.length;i++) {
				
				if(!v[i]) {
					cnt += dfs(i);
				}
			}
			System.out.println(cnt);
		}
	}


	private static int dfs(int i) {
		if(i == arr[i] || v[i]) {
			return 1;
		}
		v[i] = true;
		return dfs(arr[i]);
	}
}