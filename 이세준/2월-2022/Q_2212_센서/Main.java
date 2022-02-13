package Q_2212_센서;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		if(K>=N) {
			System.out.println(0);
			return;
		}
		
		int result = 0;
		
		String input [] =br.readLine().split(" ");
		int arr[] = new int[N];
		for(int i = 0 ; i < N;i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		
		Arrays.sort(arr);
		
		//내림차순 Collections을 사용하기 위해 Integer사용
		Integer diff [] = new Integer[N-1];
		
		for(int i =0; i<N-1;i++) {
			diff[i] = arr[i+1]-arr[i];
		}
		

		
		Arrays.sort(diff,Collections.reverseOrder());
		
		for(int i = K-1; i<N-1;i++) {
			result+= diff[i];
		}
		System.out.println(result);
		
	}
}


/*
 * 1 3 6 6 7 9 
 * 2 3 1 2 
 * 
 * */
 