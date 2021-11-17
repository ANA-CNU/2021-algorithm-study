import java.io.*;

public class garden_6198 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        long[] h = new long[n];
        long[] v = new long[n];

        for (long i = 0; i < n; i++) {
            h[(int) i] = Long.parseLong(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if ( h[i] > h[j]) {
                    v[i]++;
                } else {
                    break;
                }
            }
        }

        long result = 0;
        for (long val : v) {
            result += val;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
