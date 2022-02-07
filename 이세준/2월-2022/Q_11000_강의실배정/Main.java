package Q_11000_강의실배정;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;



class tt implements Comparable<tt>{

	int x ,y;
	@Override
	public int compareTo(tt o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int [][] arr = new int[N][2];
		
		
		for(int i =0 ; i<N;i++) {
			String input[] = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(input[0]);
			arr[i][1] = Integer.parseInt(input[1]);
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return o1[1]-o2[1];
				}
				return o1[0]-o2[0];
			}
			
		});

		
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.add(arr[0][1]);
		
		
		for(int i = 1; i < N; i++) {
			if(pq.peek() <= arr[i][0]) {
				pq.poll();
			}
			pq.add(arr[i][1]);
		}
		
		System.out.println(pq.size());
		br.close();
	}
}
