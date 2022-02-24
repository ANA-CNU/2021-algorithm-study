package Q_2195_문자열복사;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<Character, List<Integer>> map = new HashMap<>();
		char str1[] = br.readLine().toCharArray();
		for (int i = 0; i < str1.length; i++) {
			char c = str1[i];
			if(!map.containsKey(c)) {
				map.put(c, new ArrayList<>());
			}
			
			List<Integer> list = map.get(c);
			list.add(i);
			map.put(c, list);
		}
		
		char str2 [] = br.readLine().toCharArray();
		
		int i = 0, ans = 0;
		while(i<str2.length) {
			List<Integer> list = map.get(str2[i]);
			int ret =0;
			for(int idx : list) {
				int cnt = 0;
				int j=i;
				while(j < str2.length && idx < str1.length) {
					if(str2[j] == str1[idx]) {
						j++;
						idx++;
						cnt++;
						continue;
					}
					break;
				}
				ret = Math.max(ret, cnt);
			}
			i +=ret;
			ans++;
		}
		System.out.println(ans);
		
		

	}
}
