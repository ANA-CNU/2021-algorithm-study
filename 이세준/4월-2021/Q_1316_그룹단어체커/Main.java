package Q_1316_그룹단어체커;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int cnt = n;
		while(n-->0) {
			String word = br.readLine();
			Stack<Character> stack = new Stack<>();
			
			for(int i = 0; i < word.length();i++) {
				char c = word.charAt(i);
				//스택이 비어있을경우 그냥 입력
				if(stack.isEmpty()) {
					stack.push(c);
				}
				//스택에 값이 있는 경우
				else {	
					//배교 맨 위에 값과 비교 했을 때 다른 경우(새로운 초성)
					if(stack.peek() != c) {
						//전체 탐색해서
						//c가 잇는경우 (중복)
						
							if(stack.contains(c)) {
							//반복분 종료
								cnt--;
								//System.out.println(i);
								break;
							}else {
								//새롱누 단어 인 경우 추가
								stack.push(c);
							}
						
					}
					//맨 위 값과 같은 경우 (같은 초성)
					else {
						if(stack.contains(c)) {
						
						}
						stack.push(c);
					}
				}
				
				
				
				
			}
			
		}

		System.out.println(cnt);
	}
}
