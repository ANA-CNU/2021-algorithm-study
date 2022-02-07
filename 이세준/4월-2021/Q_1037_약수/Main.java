package Q_1037_약수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String input [] = br.readLine().split(" ");
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		
		for(int i = 0; i < n ; i++) {
			int x = Integer.parseInt(input[i]);
			max = x > max ? x : max;
			min = x < min ? x : min;
			
		}
		
		System.out.println(max*min);
	}
}
