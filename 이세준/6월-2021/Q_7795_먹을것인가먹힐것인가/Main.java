package Q_7795_먹을것인가먹힐것인가;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {

			String input[] = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int m = Integer.parseInt(input[1]);

			input = br.readLine().split(" ");
			int a[] = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(input[i]);
			}

			input = br.readLine().split(" ");
			int b[] = new int[m];
			for (int i = 0; i < m; i++) {
				b[i] = Integer.parseInt(input[i]);
			}

			Arrays.sort(a);
			Arrays.sort(b);
			
			int result = 0;
			int pivot = 0;
			
			for(int i =0; i< n;i++) {
				if(pivot == 0 && b[pivot] >= a[i])
				{
					continue;
				}
				while(true) {
					if(pivot == m) {
						break;
					}
					if(a[i] > b[pivot]) {
						pivot++;
					}else {
						break;
					}
				}
				
				result += pivot;
			}
			
			System.out.println(result);
		}

	}
}
