package Q_19539_사과나무;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/*
 * 물뿌리개 2개 있는데 하나는 +1 하나는 +2
 * 동시에 같은 나무에도 사용 가능
 * */
public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //나무 갯수
		String input[] = br.readLine().split(" ");
		
		//희망하는 나무 높이
		int arr  [] = new int [input.length]; 
		long sum = 0;
		int num =0;
		
		for(int i = 0; i< arr.length;i++) {
			arr[i]= Integer.parseInt(input[i]);
			sum+=arr[i];
			if(arr[i]%2 == 1) {
				num++;
			}
		}
		if(sum%3 == 0 && num<= sum/3) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	
		
		
	}
}
