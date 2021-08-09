package boj;

import java.util.*;
import java.io.*;

public class sort_10814 {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int len = Integer.parseInt(br.readLine());
		
		String arr[][] = new String[len][2];
		
		for (int i = 0; i < len; i++) {
			String val[] = br.readLine().split(" ");
			
			arr[i][0] = val[0];
			arr[i][1] = val[1];
		}
		
		Arrays.sort(arr, new Comparator<String []>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				if (Integer.parseInt(o1[0]) < Integer.parseInt(o2[0])) {
					return -1;
				} else if (Integer.parseInt(o1[0]) > Integer.parseInt(o2[0])) {
					return 1;					
				} else {
					return 0;
				}
			}
			
		});
		
//		sort(arr, 0, len);
		for (int i = 0; i < len; i++) {
			bw.write(arr[i][0] + " " + arr[i][1] + "\n");
		}
		bw.flush();
		bw.close();
	}
	
//	public static void sort(String[][] arr, int l, int r) {
//		int pivot = l;
//		int j = pivot;
//		int i = l+1;
//		String temp[];
//		
//		if (l < r) {
//			for (; i <= r; i++) {
//				if (Integer.parseInt(arr[i][0]) < Integer.parseInt(arr[pivot][0])) {
//					j++;
//					temp = arr[j];
//					arr[j] = arr[i];
//					arr[i] = temp;
//				}
//			}
//			temp = arr[l];
//			arr[l] = arr[j];
//			arr[j] = temp;
//			
//			pivot = j;
//			
//			sort(arr, l, pivot-1);
//			sort(arr, pivot+1, r);
//		}
//	}

}
