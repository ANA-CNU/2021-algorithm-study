import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[][] matrix;
    static boolean[][] visit;
    static int[] d1 = {-1, 1, 0, 0};
    static int[] d2 = {0, 0, -1, 1};
    static int count = 0;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void fill(int x1, int y1, int x2, int y2) {
        for (int i = y1; i < y2; i++) {
            for (int j = x1; j < x2; j++) {
                matrix[i][j] += 1;
            }
        }
    }

    public static void find(int x, int y) {
        if(visit[x][y]){
            return;
        }
        visit[x][y] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int x_ = x + d1[i];
            int y_ = y + d2[i];

            if (x_ >= 0 && y_ >= 0 && x_ < matrix.length && y_ < matrix[0].length) {
                if (!visit[x_][y_] && matrix[x_][y_] == 0) {
                    find(x_, y_);
                }
            }
        }


    }

    public static void main(String args[]) throws IOException {
        String[] input = br.readLine().split(" ");

        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        matrix = new int[M][N];
        visit = new boolean[M][N];

        for (int t = 0; t < K; t++) {
            input = br.readLine().split(" ");
            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);
            int x2 = Integer.parseInt(input[2]);
            int y2 = Integer.parseInt(input[3]);

            fill(x1, y1, x2, y2);
        }


        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] && matrix[i][j] < 1) {
                    count = 0;
                    find(i, j);
                    list.add(count);
                }
            }
        }

        Collections.sort(list);

        bw.write(list.size() + "\n");
        for (int i : list) {
            bw.write(i + " ");
        }
        bw.flush();

    }
}

