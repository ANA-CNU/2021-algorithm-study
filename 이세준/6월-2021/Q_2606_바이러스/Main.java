package Q_2606_바이러스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int node [][];
	static int check [];
	static int cnt2;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		node = new int [n+1][n+1];
		check = new int [n+1];
		boolean ccc[] = new boolean [n+1];
		
		int link = Integer.parseInt(br.readLine());
		
		for(int i =0; i< link;i++) {
			String input [] = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			node[a][b] = 1;
			node[b][a] = 1;
		}
		bfs(1);
		dfs(node,ccc,1);
		System.out.println("dfs : "+ (cnt2-1) );
		
	}

	private static void dfs(int[][] node2, boolean[] ccc, int v) {
		// TODO Auto-generated method stub
		if(ccc[v] == true) {
			return;
		}
		
		ccc[v] = true;
		cnt2++;
		for(int i =0;i<node2[v].length;i++) {
			if(node2[v][i]== 1 && !ccc[i]) {
				dfs(node2, ccc,i);
			}
		}
		
	}

	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		check[start] = 1;
		queue.offer(start);
		int cnt =0;
		while(!queue.isEmpty()) {
			int x = queue.poll();
			
			for(int i =1; i<node.length;i++) {
				if(node[x][i] == 1 && check[i] != 1) {
					queue.offer(i);
					check[i] = 1;
					cnt++;
				}
			}
		}
		System.out.println("bfs : "+cnt);
	}
	
}



//
//		1
//	/		\
//	2	-	5
//	/        \
//	3		 6
//	
//	4-7