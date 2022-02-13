package winter2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Tomato {
    int row;
    int column;

    Tomato(int row, int column) {
        this.row = row;
        this.column = column;
    }
}

public class Q7576 {
    static int[][] arr;
    static int answer = 0;
    static Queue<Tomato> Q;
    static int[] drow = {0, 0, 1, -1};
    static int[] dcolumn = {-1, 1, 0, 0};

    static void BFS(int M, int N) {
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Tomato t = Q.poll();
                int row = t.row;
                int column = t.column;

                for (int j = 0; j < 4; j++) {
                    int nextRow = row + drow[j];
                    int nextColumn = column + dcolumn[j];

                    if(nextRow >= 0 && nextRow < N && nextColumn >= 0 && nextColumn < M && arr[nextRow][nextColumn] == 0 ){
                        arr[nextRow][nextColumn] = arr[row][column] + 1;
                        Q.offer(new Tomato(nextRow, nextColumn));
                    }

                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    answer = -1;
                    return;
                }
                answer = Math.max(answer, arr[i][j]);
            }
        }
        answer = answer - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int M = Integer.parseInt(st.nextToken());
        final int N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        Q = new LinkedList();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    Q.offer(new Tomato(i, j));
                }
            }
        }

        BFS(M, N);
        System.out.println(answer);
    }
}
