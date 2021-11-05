package beakjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 요세푸스_문제_0_11866 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
    	
    	String input[] = sc.nextLine().split(" ");
    	int n = Integer.parseInt(input[0]);
    	int k = Integer.parseInt(input[1]);
    	
    	Queue<Integer> q = new LinkedList<>();
    	
    	for(int i=1; i<=n; i++) {
    		q.offer(i);
    	}
    	
    	int result[] = new int[n];
    	int c=0;
    	while(!q.isEmpty()) {
    		for(int i=0; i<k-1; i++) {
    			int tmp = q.poll();
    			q.offer(tmp);
    		}
    		result[c]=q.poll();
    		c++;
    	}

    	System.out.print("<");
    	for(int i=0; i<n; i++) {
    		if(i<n-1) {
    			System.out.print(result[i]+", ");
    		}
    		else {
    			System.out.print(result[i]);
    		}
    	}
    	System.out.print(">");

	}

}