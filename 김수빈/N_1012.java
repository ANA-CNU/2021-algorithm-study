import java.util.*;
import java.io.*;

public class N_1012 {

	static int M, N, K;
	static int[][] cell;
	static boolean[][] visit;
	static int count;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };

	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { x, y });

		while (!q.isEmpty()) {
			x = q.peek()[0];
			y = q.peek()[1];
			visit[x][y] = true;
			q.poll();
			for (int i = 0; i < 4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];

				if (cx >= 0 && cy >= 0 && cx < M && cy < N) {
					if (!visit[cx][cy] && cell[cx][cy] == 1) {
						q.add(new int[] { cx, cy });
						visit[cx][cy] = true;
					}
				}

			}

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		for (int c = 0; c < T; c++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			 M = Integer.parseInt(st.nextToken());
			 N = Integer.parseInt(st.nextToken());
			 K = Integer.parseInt(st.nextToken());
			 cell = new int[M][N];
			visit = new boolean[M][N];
			count=0;

			for (int i = 0; i < K; i++) {
				st=new StringTokenizer(br.readLine()," ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				cell[x][y] = 1;

			}

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (cell[i][j] == 1 && !visit[i][j]) {
						bfs(i, j);
						count++;
					}
				}
			}
			System.out.println(count);
		}
		
	}
}
