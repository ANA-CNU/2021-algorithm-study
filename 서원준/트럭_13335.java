package beakjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 트럭_13335 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
    	
    	String input[] = sc.nextLine().split(" ");
    	int n = Integer.parseInt(input[0]);
    	int w = Integer.parseInt(input[1]);
    	int l = Integer.parseInt(input[2]);
    	
    	
    	Queue<Integer> t = new LinkedList<>();
    	
    	for(int i=0; i<n; i++) {
    		t.offer(sc.nextInt());
    	}
    	
    	int time = 0;
    	int weight = 0;
    	Queue<Integer> bridge = new LinkedList<>();
    	
    	for(int i=0; i<w; i++) {
    		bridge.offer(0);
    	}
    	
    	
    	while(!bridge.isEmpty()) {
    		time++;
    		weight = weight - bridge.poll();
    		
    		if(!t.isEmpty()) {
    			if(t.peek()+weight<=l) {
        			weight = weight + t.peek();
        			bridge.offer(t.poll());
        		}
        		else {
        			bridge.offer(0);
        		}
    		}
    		
    	}
    	
    	System.out.println(time);

	}

}
