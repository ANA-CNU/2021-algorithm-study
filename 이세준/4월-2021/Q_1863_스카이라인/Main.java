package Q_1863_스카이라인;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int arr [] = new int [50002];
		for(int i = 0; i < n ; i++) {
			String input [] = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			arr[i] = y;
		}
		int answer = 0;
		
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0 ; i <= n; i++) {
			while(!stack.isEmpty() && stack.peek() > arr[i]) {
				answer++;
				stack.pop();
			}
			if(!stack.isEmpty() && stack.peek()== arr[i]) {
				continue;
			}
			stack.push(arr[i]);
		}
		System.out.println(answer);
	}
}
