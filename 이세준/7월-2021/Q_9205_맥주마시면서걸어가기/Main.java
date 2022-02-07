package Q_9205_맥주마시면서걸어가기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
	int x;
	int y;
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		ArrayList<Point> a;
		ArrayList<ArrayList<Integer>> graph;
		StringBuilder sb = new StringBuilder();
		while(t -->0) {
			int n  = Integer.parseInt(br.readLine());
			
			a = new ArrayList<Point>();
			for(int i = 0; i < n+2;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			a.add(new Point(x, y));
			}
			graph = new ArrayList<>();
			for(int i =0; i < n+2;i++) {
				graph.add(new ArrayList<>());
				
			}
			
			for(int i=0 ; i< n+2;i++) {
				for(int j =i+1; j<n+2;j++) {
					if(Manhattan(a.get(i), a.get(j)) <= 1000) {
						graph.get(i).add(j);
						graph.get(j).add(i);
						
					}
				}
			
			}
			
			sb.append((BFS(graph,n) ? "happy" : "sad") + "\n");
			
			
		}
		System.out.println(sb.toString());
	}

	private static boolean BFS(ArrayList<ArrayList<Integer>> graph, int n) {
		Queue<Integer> q = new  LinkedList<Integer>();
		q.offer(0);
		boolean [] visitied = new boolean[n+2];
		visitied[0] = true;
		while(!q.isEmpty()) {
			int now = q.poll();
			if(now == n+1) {
				return true;
			}
			for(int next : graph.get(now)) {
				if(!visitied[next]) {
					visitied[next] = true;
					q.offer(next);
				}
			}
		}
		return false;
	}

	private static int Manhattan(Point p1, Point p2) {
		// TODO Auto-generated method stub
		
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}
	
}
