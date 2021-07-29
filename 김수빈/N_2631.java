import java.util.*;
import java.io.*;
public class N_2631 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		int[] dp = new int[N];
		
		for(int i = 0; i<N; i++){
			num[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 0; i < N; i++) {
			dp[i] = 1;
		    
			for(int j = 0; j < i; j++) {    
				if(num[j] < num[i] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;	
				}
			}
		}
		int max = 0;
		for(int i = 0; i<N; i++){
			if(dp[i]>max){
				max = dp[i];
			}
		}
		System.out.println(N-max);
	}

}