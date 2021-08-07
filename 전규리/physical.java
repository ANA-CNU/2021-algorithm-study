package boj;

import java.util.*;

public class physical {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int len = Integer.parseInt(sc.nextLine());
		
		int w[] = new int[len];
		int h[] = new int[len];
		
		int[][] _p = new int[len][2];
		
		int rank[] = new int[len];
		
		for (int i = 0; i < len; i++) {
			String val[] = sc.nextLine().split(" ");
			_p[i][0] = Integer.parseInt(val[0]);
			_p[i][1] = Integer.parseInt(val[1]);
		}
		
		for (int i = 0; i < len; i++) {
			rank[i] = 1;
			for (int j = 0; j < len; j++) {
				if (_p[i][1] < _p[j][1] && _p[i][0] < _p[j][0]) {
					rank[i] += 1;
				}
			}
		}
		
		for (int i = 0; i < len; i++) {
			System.out.print(rank[i]+" ");
		}
	}
}
