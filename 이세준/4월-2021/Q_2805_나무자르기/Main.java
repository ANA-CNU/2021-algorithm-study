package Q_2805_나무자르기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input [] = br.readLine().split(" ");
		
		int n = Integer.parseInt(input[0]);//나무의 수
		int m = Integer.parseInt(input[1]);//나무의 길이
		
		input = br.readLine().split(" ");
		
		int arr [] = new int [n];
		
		long max = 0;
		
		for(int i = 0 ; i< n ; i++) {
			arr[i] = Integer.parseInt(input[i]);
			max = Math.max(max, arr[i]);
		}
		
		long min = 1;
		
		long mid = 0;
		Arrays.sort(arr);
		
		while(max >= min) {
			mid = (max + min)/2;
			
			long heigh = 0;
			
			for(int i = 0; i < arr.length;i++) {
				if(arr[i] >= mid) {
					heigh += (arr[i] - mid);
				}
				 
			}
			if(heigh >=m	) {
				min = mid+1;
			}else {
				max = mid-1;
			}
		}
		
		System.out.println(max);
	}
}
