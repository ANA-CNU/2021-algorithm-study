package Q_2493_탑;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class top {
	int num;
	int height;

	public top(int num, int height) {
		this.num = num;
		this.height = height;
	}
}

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<top> stack = new Stack<top>();
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= n; i++) {
			int height = Integer.parseInt(st.nextToken());

			if (stack.isEmpty()) {
				sb.append("0 ");
				stack.push(new top(i,height));
			}else {
				while(true) {
					if(stack.isEmpty()) {
						sb.append("0 ");
						stack.push(new top(i , height));
						break;
					}
					top t = stack.peek();
					if(t.height > height) {
						sb.append(t.num + " ");
						stack.push(new top(i,height));
						break;
					}else {
						stack.pop();
					}
				}
			}
		}
		System.out.println(sb.toString());
	}
}
