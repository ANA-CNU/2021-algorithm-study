import java.util.*;

public class N_11047 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String[] input = scan.nextLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		
		int[] coin = new int[N];
		
		for(int i = 0; i < N; i++) {
			coin[i] = scan.nextInt();
		}
		
		int count = 0;
		 
		for(int i = N - 1; i >= 0; i--) {
 
			if(coin[i] <= K) {
				count += (K / coin[i]);
				K = K % coin[i];
			}
		}
		System.out.println(count);

	}

}
