package Q_2343_기타레슨;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m  = Integer.parseInt(input[1]);
		
		int arr [] = new int [n];
		int left = 0;
		int right = 0;
		
		input = br.readLine().split(" ");
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
			right += arr[i];
			left = Math.min(left, arr[i]);
		}
		
		while(left<=right) {
			int mid = (left+right)/2;
			int sum= 0 ;
			int cnt =0;
			
			for(int i = 0; i < n ; i++) {
				if(sum + arr[i] > mid) {
					sum = 0;
					cnt++;
				}
				sum+= arr[i];
			}
			
			if(sum!=0) {
				cnt++;
			}
			
			if(cnt<=m) {
				right = mid -1;
			}else {
				left = mid+1;
			}
		}
		
		
		System.out.println(left);
		
	}
}
