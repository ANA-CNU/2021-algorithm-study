// [안정적인 문자열](https://www.acmicpc.net/problem/4889)
// 괄호 변환의 최소 횟수를 구하는 방법을 잘 정리하지 못해 헤멨음
// 맨 뒤에서부터 차근차근 변환해주면 간단하게 풀수있는 문제
// stack 하나로 while문을 돌리면서도 풀수있지만 시간 복잡도를 O(N)으로 줄이기위해 조금 더럽게 코드를 짬

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int order = 1;
		while (scanner.hasNextLine()) {
			var str = scanner.nextLine();
			if (str.contains("-")) break;
			
			Stack<Integer> opens = new Stack<>();
			Stack<Integer> closes = new Stack<>();
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '{') {
					opens.push(i);
				}
				else {
					if (opens.size() <= 0)
						closes.push(i);
					else
						opens.pop();
				}
			}
			
			System.out.print(order++ + ". ");

			if (closes.size() > opens.size())
				System.out.println((closes.size() - opens.size() % 2) / 2 + (opens.size() % 2 * 2) + (opens.size() / 2));
			else if (closes.size() < opens.size())
				System.out.println((opens.size() - closes.size() % 2) / 2 + (closes.size() % 2 * 2) + (closes.size() / 2));
			else
				System.out.println(((opens.size() - opens.size() % 2) / 2) * 2 + (opens.size() % 2 * 2));
		}
	}
}
