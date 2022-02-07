package Q_7576_토마토;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class cell {
	int x;
	int y;
	int day;

	public cell(int x, int y, int day) {

		this.x = x;
		this.y = y;
		this.day = day;
	}
}

public class Main {
	static int width;
	static int height;
	static int [][] box;
	static int[] dx = {1,-1,0,0,};
	static int [] dy = {0,0,1,-1};
	
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//String input[] = br.readLine().split(" ");
		StringTokenizer st = new StringTokenizer(br.readLine());
		width = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken()); // 반복문 먼저 돌아야 해야하는것

		box = new int [height][width];
		
		for (int i = 0; i < height; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < width; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();

	}


	static void bfs() {
		Queue<cell> q = new LinkedList<>();
		int day = 0;
		
		for(int i = 0 ; i< height;i++) {
			for(int j = 0; j < width; j++) {
				if(box[i][j] == 1) {
					q.add(new cell(i, j, 0));
				}
			}
		}
		
		while(!q.isEmpty()) {
			cell c = q.poll();
			day = c.day;
			for(int i = 0 ; i < 4; i++) {
				int nx = c.x + dx[i];
				int ny = c.y + dy[i];
				
				
				if(nx >= 0 && nx < height && ny>=0 && ny < width) {
					if(box[nx][ny] == 0) {
						box[nx][ny] =1;
						q.add(new cell(nx, ny , day+1));
						
					}
				}

			}
			
		}
		
		if(checkTomato()) {
			System.out.println(day);
		}else {
			System.out.println(-1);
		}
		
	}
	
	static boolean checkTomato() {
		for(int i = 0 ; i < height;i++) {
			for(int j= 0 ; j < width; j++) {
				if(box[i][j] == 0) {
					return false;
				}
			}
		}
		
		return true;
	}
}
