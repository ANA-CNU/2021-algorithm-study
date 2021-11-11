package beakjoon;

import java.util.*;

public class 파일정리_20291 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		Map<String, Integer> m = new HashMap<>();
		List<String> list = new LinkedList<>();
		
		for(int i=0; i<n; i++) {
			String s = sc.nextLine().split("\\.")[1];
			
			if(m.containsKey(s)) {
				m.put(s, m.get(s)+1);
			}
			else {
				list.add(s);
				m.put(s, 1);
			}
		}
		
		Collections.sort(list);
		
		for(String l:list) {
			System.out.println(l+" "+m.get(l));
		}

	}

}
