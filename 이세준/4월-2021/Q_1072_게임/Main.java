package Q_1072_게임;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static long x, y, z;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		String input[] = br.readLine().split(" ");
		x = Integer.parseInt(input[0]);
		y = Integer.parseInt(input[1]);
		z = y * 100 / x;

	
		if (z >= 99) {
			System.out.println(-1);
		} else {
			binarySearch(1, x);

		}

	}

	private static void binarySearch(long start, long end) {
		long mid = 0;
		long ratio = 0;
		while (start <= end) {
			mid = (start + end) / 2;
			ratio = (y + mid) * 100 / (x + mid);
			if (ratio > z) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		System.out.println(start);

	}
}
