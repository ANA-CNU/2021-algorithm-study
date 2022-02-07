package Q_1302_베스트셀러;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Map<String , Integer> map = new TreeMap<String, Integer>();
		
		for(int i =0; i< n ; i++) {
			String input = br.readLine();
			if(!map.containsKey(input)) {
				map.put(input, 1);
			}else {
				map.put(input, map.get(input)+1);
			}
		}
		

		
		int max = 0;
		String max_name = "";
		for(Entry<String, Integer> m : map.entrySet()) {
			if(max < m.getValue()) {
				max = m.getValue();
				max_name = m.getKey();
			}
		}
		
	
		System.out.println(max_name);
	}
}
