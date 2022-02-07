package Q_1931_회의실배정;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int [][] time = new int [n][2];
		
		for(int i = 0; i < n;i++) {
			String input [] = br.readLine().split(" ");
			int s = Integer.parseInt(input[0]);
			int e = Integer.parseInt(input[1]);
			
			time[i][0] = s;
			time[i][1] = e;
		}
		
		
		Arrays.sort(time, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
			
		});
		
		int cnt = 0;
		int prev_end_time = 0;
		
		for(int i = 0; i<n ;i++) {
			if(prev_end_time <= time[i][0]) {
				prev_end_time = time[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
