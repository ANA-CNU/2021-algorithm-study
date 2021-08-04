import java.util.*;
import java.io.*;

public class Main {
	
	static int check(char[][] a) {
		int n = a.length;
		int ans = 1;
		for (int i = 0; i < n; i++) {
			int cnt = 1;
			for (int j = 1; j < n; j++) {
				if (a[i][j] == a[i][j - 1]) {
					cnt += 1;
				} else {
					cnt = 1;
				}
				if (ans < cnt)
					ans = cnt;
			}
			cnt = 1;
			for (int j = 1; j < n; j++) {
				if (a[j][i] == a[j - 1][i]) {
					cnt += 1;
				} else {
					cnt = 1;
				}
				if (ans < cnt) {
					ans = cnt;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[][] a = new char[n][n];
		for (int i = 0; i < n; i++) {
			a[i] = br.readLine().toCharArray();
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j + 1 < n) {
					char t = a[i][j];
					a[i][j] = a[i][j + 1];
					a[i][j + 1] = t;
					int temp = check(a);
					if (ans < temp)
						ans = temp;
					t = a[i][j];
					a[i][j] = a[i][j + 1];
					a[i][j + 1] = t;
				}
				if (i + 1 < n) {
					char t = a[i][j];
					a[i][j] = a[i + 1][j];
					a[i + 1][j] = t;
					int temp = check(a);
					if (ans < temp)
						ans = temp;
					t = a[i][j];
					a[i][j] = a[i + 1][j];
					a[i + 1][j] = t;
				}
			}
		}
		System.out.println(ans);
	}

}