package Q_1781_컵라면;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Cups{
	int deadline;
	int cupnoddles;
	public Cups(int deadline, int cupnoddles) {
		this.deadline = deadline;
		this.cupnoddles = cupnoddles;
	}
}

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		List<Cups> list = new ArrayList<Cups>();

		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i =0; i <n ; i++) {
			String input [] = br.readLine().split(" ");
			int dd = Integer.parseInt(input[0]);
			int cc = Integer.parseInt(input[1]);
			list.add(new Cups(dd, cc));
		}
		Collections.sort(list, new Comparator<Cups>() {

			@Override
			public int compare(Cups o1, Cups o2) {
				if(o1.deadline == o2.deadline) {
					return o2.cupnoddles - o1.cupnoddles;
				}else {
					return o1.deadline - o2.deadline;
				}
			}


		});

		long result =0;
        for (int i = 0; i < n; i++) {
            int deadLine = list.get(i).deadline;
            int ramen = list.get(i).cupnoddles;
            pq.add(ramen);
            while (!pq.isEmpty() && pq.size() > deadLine) pq.poll();
        }
        while (!pq.isEmpty())
        	result += pq.poll();
        System.out.println(result);	

	}
}
