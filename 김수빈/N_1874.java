import java.util.*;
import java.io.*;

public class N_1874 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		int num = 0;
		boolean check = true;
		
		for(int w = 0; w<N; w++) {
			
			int value = Integer.parseInt(br.readLine());
			
			if(value > num) {
				for(int i = num + 1; i <= value; i++) {
					stack.push(i);
					sb.append('+').append('\n');
				}
				num = value; 	
			}else if(stack.peek() != value) {
				System.out.println("NO");
				check = false;		
				break;
			}
			
			stack.pop();
			sb.append('-').append('\n');
			
		}
		
		if(check) {
			System.out.println(sb);
		}
		
	}

}