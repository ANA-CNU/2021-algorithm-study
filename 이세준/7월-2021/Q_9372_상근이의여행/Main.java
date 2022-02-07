package Q_9372_상근이의여행;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int n, m, result;
	static boolean visit[];
	static int arr[][];

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String input [] = br.readLine().split(" ");
			n = Integer.parseInt(input[0]);
			m = Integer.parseInt(input[1]);
			result = 0;
			
			arr = new int [n+1][n+1];
			visit = new boolean[n+1];
			
			for(int j = 0; j< m ; j++) {
				input = br.readLine().split(" ");
				int a = Integer.parseInt(input[0]);
				int b = Integer.parseInt(input[1]);
				arr[a][b] = 1;
				arr[b][a] = 1;
			}
			bfs();
			System.out.println(result-1);
			
		}
	}

	private static void bfs() {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		visit[1] = true;
		while(!q.isEmpty()) {
			result++;
			int val = q.poll();
			for(int i = 1; i<= n; i++) {
				if(arr[val][i] != 0 && !visit[i]) {
					visit[i] = true;
					q.add(i);
				}
			}
		}
	}
}
