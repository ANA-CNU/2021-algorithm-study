package Q_1766_문제집;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input [] =br.readLine().split(" ");
		int n = Integer.parseInt(input[0]); //문제의 수
		int m = Integer.parseInt(input[1]); //정보의 개수
		
		
		int link[] = new int [n+1];
		LinkedList<Integer> list[] = new LinkedList[n+1];
		
		for(int i = 1; i <=n;i++) {
			list[i] = new LinkedList<Integer>();
		}
		

		for(int i = 0 ; i< m ; i++) {
			input = br.readLine().split(" ");
			int better = Integer.parseInt(input[0]);
			int later = Integer.parseInt(input[1]);
			list[better].add(later);
			link[later]++;
			
		}
		
		
		
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		
		for(int i = 1; i<=n;i++) {
			if(link[i] == 0) {
				pq.offer(i);
			}
			
		}
		StringBuilder sb= new StringBuilder();
		while(!pq.isEmpty()) {
			int now = pq.poll();
			sb.append(now + " ");
			Iterator<Integer> it = list[now].iterator();
			while(it.hasNext()) {
				int next = it.next();
				link[next]--;
				if(link[next] == 0) {
					pq.offer(next);
					
				}
			}
		}
		System.out.println(sb.toString());
	}
}
