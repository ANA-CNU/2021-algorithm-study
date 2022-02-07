package Q_2636_치즈;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int x , y,cheese, cnt, time;
	static int box [][];
	static boolean [][] v;
	static int dx [] = {1,-1,0,0};
	static int dy [] = {0,0,1,-1};
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		String input [] = br.readLine().split(" ");
		y = Integer.parseInt(input[0]);
		x = Integer.parseInt(input[1]);
		
		box = new int [y][x];
		
		
		//input
		for(int i = 0; i < y;i++) {
			input = br.readLine().split(" ");
			for(int j = 0; j < input.length;j++) {
				box[i][j] = Integer.parseInt(input[j]);
				if(box[i][j] == 1) {
					cheese++;
				}
			}
		}
		
		while(cheese != 0) {
			time++;
			cnt = cheese;
			meltingCheese();
		}
		System.out.println(time);
		System.out.println(cnt);
		
		
		
		
		
		//text
//		for(int i =0; i< box.length;i++) {
//			for(int j = 0 ; j< box[i].length;j++) {
//				System.out.print(box[i][j]);
//			}
//			System.out.println();
//		}
	
	
	}
	//bfs
	private static void meltingCheese() {
		// TODO Auto-generated method stub
		Queue<int []> queue = new LinkedList<int []>();
		queue.offer(new int[] {0,0});
		v= new boolean[y][x];
		
		while(!queue.isEmpty()) {
			int [] cur = queue.poll();
			for(int i =0; i< 4;i++) {
				int ny = cur[0] + dy[i];
				int nx = cur[1] + dx[i];
				if(ny < 0 || ny >= y || nx < 0 || nx>=x || v[ny][nx]) {
					continue;
				}
				if(box[ny][nx] == 1) {
					cheese--;
					box[ny][nx] = 0;
				}else if(box[ny][nx] == 0) {
					queue.offer(new int [] {ny,nx});
				}
				v[ny][nx] = true;
			}
			
		}
	}
}
