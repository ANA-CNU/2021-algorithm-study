package Q_2583_영역구하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int m,n,k;
	static int arr [][];

	static int [] dx = {1,-1,0,0};
	static int [] dy = {0,0,1,-1};
	static int area;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		m  = Integer.parseInt(st.nextToken());
		n  = Integer.parseInt(st.nextToken());
		k  = Integer.parseInt(st.nextToken());
		arr = new int [m][n];

		
		
		for(int i = 0; i< k ;i++) {
			st = new StringTokenizer(br.readLine());
			setbox(Integer.parseInt(st.nextToken()) , Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()) , Integer.parseInt(st.nextToken()));
			
		}
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int count = 0;
		
	       for(int i=0; i<m; i++) {
	            for(int j=0; j<n; j++) {
	                area = 0;
	                if(arr[i][j] == 0) {
	                    count++;
	                    dfs(i, j);
	                    pq.offer(area);
	                }
	            }
	        }
	       System.out.println(count);
	       while(!pq.isEmpty()) {
	    	   System.out.print(pq.poll() + " ");
	       }
	}
	private static void dfs(int x, int y) {
		// TODO Auto-generated method stub
        arr[x][y] = 1;
        area++;
 
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
 
            if(0 <= nx && nx < m && 0 <= ny && ny < n) {
                if(arr[nx][ny] == 0)
                    dfs(nx, ny);
            }
        }
		
	}
	private static void setbox(int lx, int ly, int rx, int ry) {
		// TODO Auto-generated method stub
		for(int i = ly; i< ry; i++) {
			for(int j = lx; j<rx; j++) {
				arr[i][j] = 1;
			}
		}
		
	}
}
