package winter2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2740 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] matrix2 = new int[M][K];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < K; j++){
                matrix2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] multipleMatrix = new int[N][K];

        for(int i = 0; i < N; i++){
            for(int j = 0; j <K; j++){
                int sum = 0;
                for(int p = 0; p < M; p++){
                    sum += matrix[i][p] * matrix2[p][j];
                }
                multipleMatrix[i][j] = sum;
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < K; j++){
                System.out.print(multipleMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
