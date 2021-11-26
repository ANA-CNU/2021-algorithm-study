import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N+1];
        String[] tmp = br.readLine().split(" ");
        for(int i=1; i<=N; i++) {
            num[i]=Integer.parseInt(tmp[i - 1]);
        }
        int[] dp = new int[N+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=i; j++){
                dp[i] = Math.max(dp[i-j]+num[j], dp[i]);
            }
        }
        System.out.println(dp[N]);
    }
}
