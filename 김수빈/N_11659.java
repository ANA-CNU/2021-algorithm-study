import java.util.*;
import java.io.*;

public class N_11659 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		long[] arr = new long[N+1];
		
		input = br.readLine().split(" ");
		for(int i = 0; i<N; i++){
			arr[i+1] = arr[i]+Integer.parseInt(input[i]);
		}
		
		for(int i = 0; i<M; i++){
			input = br.readLine().split(" ");
			long answer = arr[Integer.parseInt(input[1])] - arr[Integer.parseInt(input[0])-1];
			sb.append(answer+"\n");
		}
		System.out.println(sb.toString());

	}

}