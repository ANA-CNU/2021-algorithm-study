package Q_12015_가장긴증가하는부분수열2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String arsg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr [] = new int [n];
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		
		String input[] = br.readLine().split(" ");
		for(int i = 0; i < n ;i++) {
			int value = arr[i] = Integer.parseInt(input[i]);
			if(value > list.get(list.size()-1)) {
				list.add(value);
			}else {
				int left = 0;
				int right = list.size()-1;
				while(left < right) {
					int mid = (left+right)/2;
					if(list.get(mid) >= value) {
						right = mid;
					}else {
						left = mid +1;
					}
				}
				list.set(right, value);
			}
		}
		System.out.println(list.size()-1);
	}
}
