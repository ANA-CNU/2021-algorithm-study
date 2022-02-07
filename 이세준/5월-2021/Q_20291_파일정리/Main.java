package Q_20291_파일정리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Map<String, Integer> map =new TreeMap<String, Integer>();
		
		while(n-->0) {
			String input = br.readLine();
			String sp[] = input.split("\\.");

			String file = sp[1];
			
			if(!map.containsKey(file)) {
				map.put(file, 1);
			}else {
				map.put(file, map.get(file)+1);
			}
		}
		
		Set<String> set = map.keySet();
		Iterator iter = set.iterator();
		while(iter.hasNext()) {
			String temp = (String) iter.next();
			
			System.out.println(temp + " " + map.get(temp) );
		}
	
		
	}
}
