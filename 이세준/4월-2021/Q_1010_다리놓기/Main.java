package Q_1010_다리놓기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int [][] dp = new int [30][30];
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t =  Integer.parseInt(br.readLine());
		for(int i = 0; i< t;i++) {
			String input [] = br.readLine().split(" ");
			int left = Integer.parseInt(input[0]);
			int right = Integer.parseInt(input[1]);
			sb.append(combination(right, left)).append("\n");
			
		}
		System.out.println(sb.toString());
	}

	private static int combination(int right, int left) {

		if(dp[right][left] >0) {
			return dp[right][left]; 
		}
		
		if(right == left || left == 0) {
			return dp[right][left] = 1;
		}
		
		return dp[right][left] = combination(right-1, left-1) + combination(right-1, left);
		
		
		
	}
}
