package Q_1012_유기농배추;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static boolean check[][];
	static boolean arr[][];
	static int m, n;
	static StringBuilder sb = new StringBuilder();
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		
		
		while (t-- > 0) {
			String input[] = br.readLine().split(" ");
			int becu = Integer.parseInt(input[2]);
			m = Integer.parseInt(input[0]);
			n = Integer.parseInt(input[1]);
			int ans = 0;
			arr = new boolean[n][m];
			check = new boolean[n][m];
			for (int i = 0; i < becu; i++) {
				String po[] = br.readLine().split(" ");
				int x = Integer.parseInt(po[0]);
				int y = Integer.parseInt(po[1]);
				arr[y][x] = true;
				
			}
			
			for(int j =0; j < n;j++) {
				for(int k =0; k< m ;k++) {
					if(checkLocation(j,k) == true) {
						ans++;
						dfs(j,k);
					}
				}
				
			}
		sb.append(ans + "\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int x, int y) {
		// TODO Auto-generated method stub
		check[x][y] = true;
		if(checkLocation(x-1, y)) {
			dfs(x-1,y);
		}
		if(checkLocation(x+1, y)) {
			dfs(x+1,y);
		}
		
		if(checkLocation(x, y-1)) {
			dfs(x,y-1);
		}
		
		if(checkLocation(x, y+1)) {
			dfs(x,y+1);
		}
		
		
		
	}

	private static boolean checkLocation(int row, int col) {
		// TODO Auto-generated method stub
		
		if(row < 0  || row >= n || col < 0 || col >=m) {
			return false;
			
		}
		if(check[row][col] == true || arr[row][col] == false) {
			return false;
		}
		return true;
	}
}


/*
 *  bfs 는 넓이 우선 탐색 --> 트리로 생각하면
 *  레벨탐색트리라 생각이 가능하다
 *  이건 Queue를 사용했다.
 *  
 *  그렇다면 dfs는 깊이 우선 탐색이다 --> 트리로 생각하면 전위순회??
 *  재귀에서 먼저 출력을하고 죄우 탐색을 들어가는 그런 구조를 말하는 것이다.
 * 
 * 
 * 
 * 
 * */
