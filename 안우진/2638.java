// BOJ 2636 과 같은 문제

import java.io.*;
import java.util.*;

public class Main {
	
	static final int[] dx = {0,0,1,-1};
	static final int[] dy = {1,-1,0,0};
	
	static int N,M;
	static int[][] map;
	static int cheeze, time;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		N=Integer.parseInt(tmp[0]); M=Integer.parseInt(tmp[1]);
		map = new int[N][M];
		map[0][0]=-1;
		time=1;cheeze=0;
		for(int i=0; i<N; i++) {
			tmp = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(tmp[j]);
				if(map[i][j]==1) {
					cheeze+=1;
				}
			}
		}
		br.close();
		while(dfs()) {
			time+=1;
		}
		System.out.print(time);

	}
	
	static boolean dfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0,0});
		boolean[][] visit = new boolean[N][M];
		visit[0][0]=true;
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int y = tmp[0];
			int x = tmp[1];
			for(int i=0; i<4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(Range(ny,nx) && !visit[ny][nx] && map[ny][nx]!=1) {
					visit[ny][nx]=true;
					q.offer(new int[] {ny,nx});
					map[ny][nx] = -1;
				}
			}
		}
		
		for(int y=0; y<N; y++) {
			for(int x=0; x<M; x++) {
				if(map[y][x] != 1) continue;
				int cnt = 0;
				for(int i=0; i<4; i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];
					if(Range(ny,nx) && map[ny][nx] == -1) {
						cnt+=1;
						if(cnt>=2) {
							map[y][x]=0;
							cheeze-=1;
							break;
						}
					}
					
				}
			}
		}
		if(cheeze==0) {
			return false;
		}
		return true;
	}
	
	static boolean Range(int y, int x) {
		return 0 <= y && y < N && 0 <= x && x < M;
	}

}
