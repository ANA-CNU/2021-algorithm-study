package Q_1697_숨바꼭질;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 걷는 경우 +-1
 * 순간이동 *z
 * 
 * bfs 문제 : Queue탐색이다
 */

public class Main {
	static int n,k;
	static int check[] = new int [100001]; //체크용
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input [] = br.readLine().split(" ");
		 n = Integer.parseInt(input[0]);
		 k = Integer.parseInt(input[1]);
		 
		 if(n==k) {
			 System.out.println(0);
		 }else {
			 bfs(n);
		 }
		
	}
	private static void bfs(int num) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(num);
		check[num] = 1; //해당 수에 방문을 했다고 1을 넣어줌
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			//왜 3이냐면 움직이는 조건이 3개이기 때문이다.
			for(int i = 0; i<3;i++) {
				int next;
				if(i == 0) {
					next = temp + 1;
				}else if(i == 1) {
					next = temp -1;
				}else {
					next = temp *2;
				}
				
				if(next == k) {
					System.out.println(check[temp]);
					return;
				}
				
				if( next >= 0 && next < check.length && check[next] == 0) {
					queue.add(next);
					check[next] = check[temp]+1;
				}
			}
		}
		
		
	}
}
