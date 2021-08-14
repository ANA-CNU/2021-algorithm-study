import java.util.*;
import java.io.*;

public class N_11728 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int A = Integer.parseInt(input[0]);
		int B = Integer.parseInt(input[1]);
		
		int[] arrA = new int[A];
		int[] arrB = new int[B];
		int[] merge = new int[A+B];
		
		input = br.readLine().split(" ");
		
		for(int i = 0; i<A; i++) {
			arrA[i] = Integer.parseInt(input[i]);
		}
		
		input = br.readLine().split(" ");
		
		for(int i = 0; i<B; i++) {
			arrB[i] = Integer.parseInt(input[i]);
		}
		
		int i=0, j=0, k=0;
		
		while(i<A && j<B) {
			if(arrA[i]>arrB[j]) {
				merge[k++] = arrB[j++];
			}else {
				merge[k++] = arrA[i++];
			}
		}
		
		while(i<A) {
			merge[k++] = arrA[i++];
		}
		
		while(j<B) {
			merge[k++] = arrB[j++];
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int w = 0; w<merge.length; w++) {
			sb.append(merge[w]+" ");
		}
		System.out.println(sb.toString());
	}

}
