package winter2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tomato3D {
    int x;
    int y;
    int z;

    Tomato3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Q7569 {
    static int[][][] board;
    static Queue<Tomato3D> Q;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int M, N, H, answer = 0;

    static void DFS() {
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Tomato3D t = Q.poll();
                int x = t.x;
                int y = t.y;
                int z = t.z;

                for (int j = 0; j < 6; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    int nz = z + dz[j];

                    if (nx >= 0 && nx < M && ny >= 0 && ny < N && nz >= 0 && nz < H && board[nx][ny][nz] == 0) {
                        Q.offer(new Tomato3D(nx, ny, nz));
                        board[nx][ny][nz] = board[x][y][z] + 1;
                    }
                }
            }
//            for (int i = 0; i < H; i++) {
//                for (int j = 0; j < N; j++) {
//                    for (int k = 0; k < M; k++) {
//                        System.out.print(board[k][j][i]);
//                    }
//                    System.out.println();
//                }
//                System.out.println();
//            }
        }
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    answer = Math.max(answer, board[k][j][i]);
                    if (board[k][j][i] == 0) {
                        answer = -1;
                        return;
                    }
                }
            }
        }
        answer -= 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        board = new int[M][N][H];
        Q = new LinkedList();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    board[k][j][i] = Integer.parseInt(st.nextToken());
                    if (board[k][j][i] == 1) {
                        Q.offer(new Tomato3D(k, j, i));
                    }
                }
            }
        }
        DFS();
        System.out.println(answer);
    }
}
