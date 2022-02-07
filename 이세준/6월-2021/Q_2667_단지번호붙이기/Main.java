package Q_2667_단지번호붙이기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int n;
	static int dx[]  = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	static int [] apart = new int [25*25];
	static int apartnum = 0;
	static boolean visited [][] = new boolean [25][25];
	static int map[][]= new int [25][25];
	
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		map = new int [n][n];
		visited = new boolean[n][n];
		
		for(int i = 0; i< n ; i++) {
			String input = br.readLine();
			for(int j =0; j<input.length();j++) {
				map[i][j] = input.charAt(j)-'0';
			}
		}
		
		for(int i =0; i< n; i++) {
			for(int j=0; j<n;j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					apartnum++;
					bfs(i,j);
				}
			}
		}
		
		Arrays.sort(apart);
		System.out.println(apartnum);
		for(int i =0; i< apart.length;i++) {
			if(apart[i] != 0) {
				System.out.println(apart[i]);
			}
		}
	}


	private static void bfs(int x, int y) {
		// TODO Auto-generated method stub
		Queue<int[]> que = new LinkedList<int[]>();
		que.add(new int[] {x,y});
		visited[x][y] = true;
		apart[apartnum]++;
		
		while(!que.isEmpty()) {
			int curx = que.peek()[0];
			int cury = que.peek()[1];
			que.poll();
			
			for(int i =0; i<4;i++) {
				int nx = curx + dx[i];
				int ny = cury + dy[i];
				
				if(nx >= 0 && ny >= 0 && nx< n && ny < n) {
					if(map[nx][ny] == 1 && !visited[nx][ny] ) {
						que.add(new int[] {nx,ny});
						visited[nx][ny] = true;
						apart[apartnum]++;
					}
				}
			}
		
		}
		
	}
}
