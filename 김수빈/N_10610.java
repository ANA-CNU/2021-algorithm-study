import java.io.*;
import java.util.*;

public class N_10610 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split("");
		int[] num = new int[10];
		int all = 0;
		
		for(int i = 0; i<input.length; i++) {
			int temp = Integer.parseInt(input[i]);
			num[temp]++;
			all += temp;
		}
		
		StringBuilder sb = new StringBuilder();
		
		if(num[0]==0 || all % 3 != 0) {
			System.out.println("-1");
		}else{
			for(int i = 9; i>=0; i--) {
				while(num[i]-->0){
					sb.append(i);
				}
			}
			
			System.out.println(sb.toString());
		}
	}

}
