package Q_4949_균형잡힌세상;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
	      
        while (true) {
            Stack<Character> stack = new Stack<Character>();
            String input = br.readLine();
            if(input.equals(".")){
                break;
            }
            String all = input.trim();
            for (int i = 0; i < all.length(); i++) {
                char text = all.charAt(i);
                if (text == '(' || text == '{' || text == '[') {
                    stack.add(text);
                } else if (text == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.add(text);
                    }
                } else if (text == '}') {
                    if (!stack.isEmpty() && stack.peek() == '{') {
                        stack.pop();
                    } else {
                        stack.add(text);
                    }
                } else if (text == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        stack.add(text);
                    }
                }

                if (text == '.') {
                    if (stack.isEmpty()) {
                        System.out.println("yes");
                    } else {
                        System.out.println("no");
                    }
                    break;
                }

            }

        }
	}
}
