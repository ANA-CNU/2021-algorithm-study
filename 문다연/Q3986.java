package algorithm;

import java.util.*;
import java.io.*;

public class Q3986 {

	static boolean goodWords(Stack<String> stack) {

		Stack<String> chkStack = new Stack<>();

		while (!stack.empty()) {

			String tmp = stack.pop();
			if (chkStack.empty()) {
				chkStack.push(tmp);
			} else {
				if (chkStack.peek().equals(tmp))
					chkStack.pop();
				else
					chkStack.push(tmp);
			}
		}

		if (!chkStack.empty())
			return false;
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<String> stack;
		int n = Integer.parseInt(br.readLine());
		int cnt = 0; // 좋은 글자의 개수

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			stack = new Stack<String>();
			for (int j = 0; j < str.length(); j++) {
				stack.push(str.charAt(j) + "");
			}
			if (goodWords(stack))
				cnt++;
		}
		System.out.println(cnt);
	}
}
