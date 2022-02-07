package Q_9012_괄호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		
		
		
		while(n-- > 0) {
			Stack<Character> stack = new Stack<Character>();
			String input = br.readLine();
			for(int i = 0; i < input.length(); i++) {
				char text = input.charAt(i);
			
				if(text == '(') {
					stack.push(text);
				}else if(text == ')') {
					if(!stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
					}else {
						stack.push(text);
					}
				}
				
				
				
				
			}
			
			if(stack.isEmpty()) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}
}
