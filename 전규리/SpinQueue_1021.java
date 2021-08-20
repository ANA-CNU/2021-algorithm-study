package boj;

import java.util.*;

public class SpinQueue_1021 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		LinkedList<Integer> que = new LinkedList<>();
		
		int s = sc.nextInt();
		int l = sc.nextInt();
		
		int cnt = 0;
		
		for (int i = 1; i <= s; i++) {
			que.add(i);
		}
		
		for (int i = 0; i < l; i++) {
			int val = sc.nextInt();
			while(true) {
				int idx = que.indexOf(val);
				if (idx == 0) {
					que.remove();
					break;
				} else if (idx < que.size()/2+1) {
					int tmp = que.peek();
					que.remove();
					que.offer(tmp);
					cnt++;
				} else if (idx >= que.size()/2+1) {
					int tmp = que.peekLast();
					que.removeLast();
					que.addFirst(tmp);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

}
