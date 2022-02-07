package Q_13414_수강신청;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input [] = br.readLine().split(" ");
		int k = Integer.parseInt(input[0]); //신청 가능 인원 
		
		int l = Integer.parseInt(input[1]); // 반복횟수
		
		Map<String, Integer> map = new HashMap<String,Integer>();
		
		for(int i = 0; i< l ; i++) {
			String number = br.readLine();
			
			if(!map.containsKey(number)) {
				map.put(number, i);
			}else {
				map.remove(number);
				map.put(number, i);
			}
			
			
		}
		//Map의 Value값으로 정렬하는 방법
		List<String> keySetList = new ArrayList<>(map.keySet());
		
		Collections.sort(keySetList , (o1,o2) -> (map.get(o1).compareTo(map.get(o2))));
		
		int cnt = 0;
		for(String key : keySetList) {
//			System.out.println(key + " : " + map.get(key));
			System.out.println(key);
			cnt++;
			if(cnt >= k) {
				break;
			}
		}
		
	
	}
}
