package Q_1911_흙길보수하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		String input [] = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int L = Integer.parseInt(input[1]);
		
		long arr [][] = new long[N][2];

		for(int i = 0; i < N ; i++) {
			input = br.readLine().split(" ");
			long a = Long.parseLong(input[0]);
			long b = Long.parseLong(input[1]);
		
			arr[i][0]= a;
			arr[i][1] = b;
		}
		
		Arrays.sort(arr, new Comparator<long []>() {

			// 물웅덩이의 시작 위치를 기준으로 오름차순 -> 시작 위치가 동일하면 끝 위치를 기준으로 오름차순
			@Override
			public int compare(long[] o1, long[] o2) {
				if(o1[0] == o2[0])
					return Long.compare(o1[1], o2[1]);
				return Long.compare(o1[0], o2[0]);
			}
		});

		
		int nulpan = 0;	// 필요한 널빤지의 개수
		long range = 0;	// 널빤지를 물웅덮이에 덮었을때, 덮을 수 있는 범위
		for(int i=0; i<N; i++) {
			if(arr[i][0] > range)
				range = arr[i][0];
			if(arr[i][1] >= range) {
				while(arr[i][1] > range) {
					range += L;
					nulpan ++;
				}
			}
		}

		System.out.println(nulpan);
		br.close();
	
	}
}
