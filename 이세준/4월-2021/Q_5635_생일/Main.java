package Q_5635_생일;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class student {
	String name;
	int dd, mm, year;

	public student(String name, int dd, int mm, int year) {
		this.name = name;
		this.dd = dd;
		this.mm = mm;
		this.year = year;
	}
}

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
	
		List<student>list =new ArrayList<student>();
		
		
		for(int i = 0; i< n; i ++) {
			String input [] = br.readLine().split(" ");
			String name = input[0];
			int dd = Integer.parseInt(input[1]);
			int mm = Integer.parseInt(input[2]);
			int year = Integer.parseInt(input[3]);
			list.add(new student(name, dd, mm, year));
		}
		
		Collections.sort(list, new Comparator<student>() {
			public int compare(student o1, student o2) {
				if(o1.year == o2.year) {
					if(o1.mm == o2.mm) {
						
						if(o1.dd == o2.dd) {
							return 0;
						}
						return o1.dd - o2.dd;
						
					}
					return o1.mm - o2.mm;//월 비교
				}
				
				return o1.year - o2.year; // 나이 오름차순
			}
		});
		
		System.out.println(list.get(0).name);
		System.out.println(list.get(list.size()-1).name);
	}
}
