package Q_1461_도서관;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> positivepq = new PriorityQueue<Integer>((p1,p2)->(p2-p1));
		PriorityQueue<Integer> negativepq = new PriorityQueue<Integer>((p1,p2)->(p2-p1));
		
		String input[]= br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		input = br.readLine().split(" ");
		

		for(int i =0; i< n;i++) {
			
			int temp = Integer.parseInt(input[i]);
			
			if(temp >0) {
				positivepq.add(temp);
			}else {
				negativepq.add(Math.abs(temp));
			}
			
		}
		
		
		int Max = 0;
		
		if(positivepq.isEmpty()) {
			Max = negativepq.peek();
		}else if(negativepq.isEmpty()) {
			Max = positivepq.peek();
		}else {
			Max = Math.max(positivepq.peek(), negativepq.peek());
		}
		
		
		int ans = 0;
		
		while(!positivepq.isEmpty()) {
			int temp = positivepq.poll();
			for(int i = 0; i< m-1; i++) {
				positivepq.poll();
				if(positivepq.isEmpty()) {
					break;
				}
			}
			ans+=temp*2;
		}
		
		while(!negativepq.isEmpty()) {
			int temp = negativepq.poll();
			for(int i = 0; i< m-1; i++) {
				negativepq.poll();
				if(negativepq.isEmpty()) {
					break;
				}
			}
			ans+=temp*2;
		}
		
		ans -= Max;
		System.out.println(ans);
	}
}
