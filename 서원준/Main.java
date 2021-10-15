import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.nextLine();

		Stack<Character> stack = new Stack<>();
		String[] ps = new String[Integer.parseInt(n)];

		for (int i = 0; i < Integer.parseInt(n); i++) {
			ps[i] = sc.nextLine();
			boolean answer = true;
			
			for (int j = 0; j < ps[i].length(); j++) {
				if (ps[i].charAt(j) == '(') {
					stack.push(ps[i].charAt(j));
				}
				else {
					if (stack.size() > 0) {
						stack.pop();
					}
					else {
						answer = false;
						break;
					}
				}

				if (!answer) {
					break;
				}
			}

			if (stack.size() > 0) {
				answer = false;
			}

			if (answer) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			stack.clear();
		}
	}
}