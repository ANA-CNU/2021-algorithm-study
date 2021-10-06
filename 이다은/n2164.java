package Week4;

import java.util.*;

public class n2164 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i=1;i<=num;i++){
			queue.offer(i);
		}
		
		while(queue.size()>1){
			queue.poll();
			int tmp = queue.poll();
			queue.offer(tmp);
		}
		
		System.out.println(queue.poll());
	}
}
