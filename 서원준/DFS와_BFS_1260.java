package beakjoon;

import java.util.*;

public class DFS와_BFS_1260 {
	static int check[][] = new int[1001][1001];
	static boolean visited[] = new boolean[1001];
	static int n;
	static int m;
	static int start;
	
	static void dfs(int start) {
		visited[start] = true;
		System.out.print(start+" ");
		
		for(int i=0; i<n+1; i++) {
			if(check[start][i]==1 && visited[i]==false) {
				dfs(i);
			}
		}		
	}
	
	 static void bfs(int start) {
		 Queue<Integer> q = new LinkedList<>();
		 q.offer(start);
		 visited[start] = true;
		 
		 while(!q.isEmpty()) {
			 int t = q.poll();
			 System.out.print(t+" ");
			 
			 for(int i=0; i<n+1; i++) {
				 if(check[t][i]==1 && visited[i]==false) {
					 q.offer(i);
					 visited[i]=true;
					 
				 }
			 }
		 }
	 }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		
		String input[] = sc.nextLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		start = Integer.parseInt(input[2]);
		
		for(int i=0; i<m; i++) {
			String str[] = sc.nextLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			check[x][y] = check[y][x] = 1;
		}
		dfs(start);
		System.out.println();
		
		visited = new boolean[1001];
		bfs(start);
		
	}

}
