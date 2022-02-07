package Q_1300_K번째수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		long ans =0;
		long left = 1;
		long right = k;
		while(right>=left) {
			long middle = (left+right)/2;
			long cnt = 0;
			
			
			//mid보다 작거나 같은 수는 몇개인지 계산
			for(int i = 1 ; i <= n; i++) {
				cnt+=Math.min(middle/i, n);
			}
			if(cnt < k) {
				left = middle+1;
			}else {
				ans =middle;
				right = middle-1;
			}
			
		}
	
		System.out.println(ans);
	}
	
}
