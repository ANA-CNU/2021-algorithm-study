package winter2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2447 {
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = ' ';
            }
        }

        board = recursive(N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static char[][] recursive(int N) {
        if(N == 1){
            char[][] cArr = new char[N][N];
            cArr[0][0] = '*';
            return cArr;

        } else {
            char[][] prevArr = recursive(N / 3);
            for (int i = 0; i < N / 3; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        if(k == 1 && j == 1) continue;
                        System.arraycopy(prevArr[i], 0, board[i + k*N/3], j * N / 3, N / 3);
                    }
                }
            }
            return board;
        }
    }

}
