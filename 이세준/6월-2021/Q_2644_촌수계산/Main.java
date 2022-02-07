package Q_2644_촌수계산;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
//bfs level queue
public class Main {
	static int n , m;
	static int x , y; // p1,p2
	static int [][]map;
	static int d[];
	
	static int a, b;
	
	static boolean [] isvisited;
	public static void main(String args[]) throws Exception {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		n  = Integer.parseInt(br.readLine());
		String input [] = br.readLine().split(" ");
		x = Integer.parseInt(input[0]);
		y = Integer.parseInt(input[1]);
		map = new int [n+1][n+1];
		
		
		m = Integer.parseInt(br.readLine());
	
		//a 가 b 의 부모
		while(m-->0) {
			input = br.readLine().split(" ");
			a = Integer.parseInt(input[0]);
			b = Integer.parseInt(input[1]);
			//방문인증
			map[a][b] = 1;
			map[b][a] = 1;
			
		}
		d = new int [n+1];
		bfs(x,y);
		if(d[y] == 0) {
			System.out.println(-1);
		}else {
			System.out.println(d[y]);
		}
	}
	private static void bfs(int start, int end) {
		Queue<Integer> q = new LinkedList<Integer>();

		q.add(start);
		while(!q.isEmpty()) {
			int v = q.poll();
			if(v == end) {
				break;
			}
			
			
			
			for(int i =1; i<=n;i++) {
				if(map[v][i] == 1 && d[i] == 0) {
					d[i] = d[v] + 1;
				q.add(i);
				}
			}
		}
	
	}
}
