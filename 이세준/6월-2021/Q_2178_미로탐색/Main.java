package Q_2178_미로탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;



public class Main {

		static int n,m;
		static int arr[][];
		static boolean [][] visited;
		static int dx []= {-1,0,1,0};
		static int dy[] = {0,-1,0,1};
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		String iput[] = br.readLine().split(" ");
		//2<= n,m <= 100
		 n = Integer.parseInt(iput[0]);
		 m = Integer.parseInt(iput[1]);
		arr = new int[n][m];
		
		visited = new boolean[n][m];
		
		
		for(int i =0; i< n;i++) {
			String line = br.readLine();
			for(int j=0; j < m;j++) {
				arr[i][j] = line.charAt(j)-'0';
				visited[i][j] = false;
			}
		}
		
		visited[0][0] = true;
		BFS(0,0);
		System.out.println(arr[n-1][m-1]);
		
		
	}

	private static void BFS(int x, int y) {
		Queue<Dot> q = new LinkedList<>();
		q.add(new Dot(x, y));
		
		while(!q.isEmpty()) {
			Dot d = q.poll();
			for(int i =0; i< 4;i++) {
				int nextx = d.x+dx[i]	;
				int nexty = d.y+dy[i];
				
				if(nextx < 0 || nexty < 0|| nextx>=n || nexty>=m) {
					continue;
				}
				if(visited[nextx][nexty] || arr[nextx][nexty] == 0) {
					continue;
				}
				
				q.add(new Dot(nextx, nexty));
				
				arr[nextx][nexty] = arr[d.x][d.y]+1;
				visited[nextx][nexty] = true;
			}
		}
		
	}
}


class Dot{
	int x;
	int y;
	public Dot(int x, int y) {
		this.x= x;
		this.y = y;
	}
}