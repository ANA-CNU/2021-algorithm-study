package Q_10773_제로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		
		while(k--> 0) {
			int input = Integer.parseInt(br.readLine());
			if(input == 0) {
				stack.pop();
			}else
				stack.add(input);
		}
	
		int answer = 0;
		if(!stack.isEmpty()) {
			while(!stack.isEmpty()) {
				answer += stack.pop();
				
			}
			System.out.println(answer);
		}else {
			System.out.println(answer);
		}
	}
	
}
