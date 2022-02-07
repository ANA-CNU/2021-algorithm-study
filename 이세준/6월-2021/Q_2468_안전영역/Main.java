package Q_2468_안전영역;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int map[][];
	static int [][]transmap;
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static boolean [][] check;
	static int count;
	static int max;
	public static void main(String args[]) throws Exception {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		 n = Integer.parseInt(br.readLine()); // 이차원배열
		 map= new int [n][n];
		
		for(int i = 0; i < n ; i++) {
			String input [] = br.readLine().split(" ");
			for(int j =0; j< n;j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		max = 1;
		
		for(int i = 1; i< 101; i++) {
			transmap = new int [n][n];
			count = 0;
			check = new boolean [n][n];
			
			for(int a =0; a < n; a++) {
				for(int b= 0; b<n;b++) {
					if(map[a][b] <= i) {
						transmap[a][b] = 0;
					}else {
						transmap[a][b] = 1;
						
					}
				}
			}
			
			for(int a = 0; a< n ; a++) {
				for(int b = 0; b< n ; b++) {
					System.out.println(check[a][b]);
					if(transmap[a][b] == 1 && !check[a][b] ) {
						dfs(a,b);
						count++;
					}
				}
				
			}
			max = Math.max(max, count);
		}
		System.out.println(max);
	}
	private static void dfs(int a, int b) {
		check[a][b] = true;
		for(int i =0; i<4;i++) {
			int nx = a + dr[i];
			int ny = b + dc[i];
			
			if(nx >= 0 && ny>=0 && nx<n && ny<n) {
				if(transmap[nx][ny] == 1 && !check[nx][ny]) {
					dfs(nx,ny);
				}
			}
		}
		
	}
}
