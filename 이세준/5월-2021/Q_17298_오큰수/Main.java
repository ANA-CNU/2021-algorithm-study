package Q_17298_오큰수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n  = Integer.parseInt(br.readLine());
		String input [] = br.readLine().split(" ");
		int arr [] = new int[input.length];
		for(int i = 0; i < input.length;i++) {
			arr[i] = Integer.parseInt(input[i]);
			
		}
		
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < arr.length;i++) {
			
			while(!stack.isEmpty() &&  arr[stack.peek()] < arr[i]) {
				arr[stack.pop()] = arr[i];
			}
			stack.push(i);
			
		}
		
		
		while(!stack.isEmpty()) {
			arr[stack.pop()] = -1;
		}
		
		for(int i = 0; i< arr.length;i++) {
			sb.append(arr[i]).append(" ");
		}
		System.out.println(sb);
	}
}
