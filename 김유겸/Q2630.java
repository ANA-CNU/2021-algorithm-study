package winter2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2630 {
    static int[][] board;
    static int blue = 0, white = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        board = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        division(N, board);

        System.out.println(white);
        System.out.println(blue);
    }

    static void division(int N, int[][] cBoard) {
        int check = checkSameColor(N, cBoard); //check:0(white), 1(Blue), 2(X)
        if (check == 0) {
            white ++;
        }else if(check == 1){
            blue ++;
        } else{
            int[][] arr1 = new int[N / 2 + 1][N / 2 + 1];
            int[][] arr2 = new int[N / 2 + 1][N / 2 + 1];
            int[][] arr3 = new int[N / 2 + 1][N / 2 + 1];
            int[][] arr4 = new int[N / 2 + 1][N / 2 + 1];

            for(int i = 1; i <= N/2; i++){
                System.arraycopy(cBoard[i], 1, arr1[i], 1, N / 2);
                System.arraycopy(cBoard[i], N / 2 + 1, arr2[i], 1, N / 2 );
                System.arraycopy(cBoard[i + N/2], 1, arr3[i], 1, N / 2 );
                System.arraycopy(cBoard[i + N/2], N / 2 + 1, arr4[i], 1, N / 2 );
            }

            division(N/2, arr1);
            division(N/2, arr2);
            division(N/2, arr3);
            division(N/2, arr4);
        }
    }

    static int checkSameColor(int N, int[][] cBoard) {
        int color = cBoard[1][1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (cBoard[i][j] != color) {
                    return 2;
                }
            }
        }
        return color;
    }
}
