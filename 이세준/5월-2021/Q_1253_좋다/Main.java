package Q_1253_좋다;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {
	public static class Good{
		boolean flag;
		HashSet<Integer> idx;
		public Good(boolean flag, HashSet<Integer>idx) {
			this.flag = flag;
			this.idx = idx;
		}
	}
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String input [] = br.readLine().split(" ");
		int arr [] = new int [n];
		int cnt = 0;
		
		Map<Integer, Good> map = new HashMap<Integer,Good>();
		
		for(int i = 0; i  < n ; i++	) {
			arr[i] = Integer.parseInt(input[i]);
			if(map.containsKey(arr[i])) {
				map.get(arr[i]).idx.add(i);
			}else {
				HashSet<Integer> set = new HashSet<Integer>();
				set.add(i);
				map.put(arr[i], new Good(false, set));
				
			}
		}
		
		for(int i = 0; i < n-1; i++) {
			int a = arr[i];
			for(int  j = i+1; j<n;j++) {
				int b = arr[j];
				int sum = a+b;
				
				if(map.containsKey(sum)) {
					int flag = 0;
					if(map.get(sum).idx.contains(i)) {
						flag++;
					}
					if(map.get(sum).idx.contains(j)) {
						flag++;
					}
					
					if(flag == 0) {
						map.get(sum).flag = true;
					}else {
						if(map.get(sum).idx.size()>flag) {
							map.get(sum).flag = true;
						}
					}
				}
			}
		}
	
	for(Good g : map.values()) {
		if(g.flag) {
			cnt+=g.idx.size();
		}
	}
	System.out.println(cnt);
	}
	
	

}
