package Q_6236_용돈관리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input [] = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		int max  =0;

		int min = 0;
		int arr []  = new int [n];
		for(int i = 0; i< n ;i++) {
			int money = Integer.parseInt(br.readLine());
			arr[i] =money;
			max += arr[i];
			min = arr[i] > min ? arr[i] : min;
		}
		
		Arrays.sort(arr);
//		System.out.println(arr[n-1]);
//		System.out.println(max);
//		
//		System.out.println(min);
//		
		while(min <= max) {
			int mid = (max + min)/2;
			
			int sum = 0;
			int cnt = 0;
			
			for(int i =0; i< n; i++) {
				if(sum + arr[i] > mid	) {
					sum = 0;
					cnt ++;
				}
				sum+= arr[i];
			}
			if(sum!=0) {
				cnt++;
			}
			if(cnt <= m) {
				max = mid -1;
			}else {
				min = mid +1;
			}
		}
		
		//System.out.println(max);
		System.out.println(min);
	}
}
