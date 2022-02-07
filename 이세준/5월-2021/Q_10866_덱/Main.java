package Q_10866_덱;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Deque <Integer> deque = new LinkedList<Integer>();
		
		
		int n = Integer.parseInt(br.readLine());
		
		while(n--> 0 ) {
			String input [] = br.readLine().split(" ");
			String control = input[0];
			switch(control) {
			case "push_back":
				int value = Integer.parseInt(input[1]);
				deque.addLast(value);
				break;
			case "push_front":
				 value = Integer.parseInt(input[1]);
				deque.addFirst(value);
				break;
			case "pop_front":
				if(deque.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(deque.removeFirst());
				}
				break;
			case "pop_back":
				if(deque.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(deque.removeLast());
				}
				break;
			case "size":
				System.out.println(deque.size());
				break;
			case "empty":
				if(deque.isEmpty()) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
				break;
			case "front":
				if(deque.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(deque.getFirst());
				}
				break;
				
			case "back":
				if(deque.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(deque.getLast());
				}
				break;
			}
		}
		
	}
}
