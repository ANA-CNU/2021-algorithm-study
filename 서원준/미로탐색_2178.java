package beakjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로탐색_2178 {
	static int map[][];
	static int n;
	static int m;
	static boolean visited[][];
	static int dx[] = {1, -1, 0, 0}; // 상, 하
	static int dy[] = {0, 0, -1, 1}; // 좌, 우

	
	static void bfs(int x, int y) {
		Queue<xy> q = new LinkedList<>();
		q.offer(new xy(x,y));
		
		while(!q.isEmpty()) {
			xy d = q.poll();
			for(int i=0; i<4; i++) {
				int nextX = d.x + dx[i];
				int nextY = d.y + dy[i];
				
				//다음 좌표가 범위를 넘어갈때 건너뛰기
				if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
                    continue;
                }
				
                //이미 방문했던 점이면 건너뛰기
                if (visited[nextX][nextY] || map[nextX][nextY] == 0) {
                    continue;
                }
                
                q.offer(new xy(nextX,nextY));
                map[nextX][nextY] = map[d.x][d.y] + 1 ;
                visited[nextX][nextY] = true;
			}
		}
	}
	
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	String input[] = sc.nextLine().split(" ");
    	n = Integer.parseInt(input[0]);
    	m = Integer.parseInt(input[1]);
    	
    	map = new int[n][m];
    	visited = new boolean[n][m];
    	
    	for(int i=0; i<n; i++) {
    		String str[] = sc.nextLine().split("");
    		for(int j=0; j<m; j++) {
    			map[i][j] = Integer.parseInt(str[j]);
    	    	visited[i][j] = false;
    		}
    	}
    	visited[0][0] = true;
    	bfs(0,0);
    	System.out.println(map[n-1][m-1]);
    }

}


class xy {
    int x;
    int y;
    xy(int x, int y) {
        this.x = x;
        this.y = y;
    }
}