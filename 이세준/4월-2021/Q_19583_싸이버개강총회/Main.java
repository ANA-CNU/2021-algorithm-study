package Q_19583_싸이버개강총회;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;



public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		String time []  = br.readLine().split(" ");
		String s = time[0];
		String e = time[1];
		String q = time[2];
		
		String input = "";
		Set<String> enter  = new HashSet<String>();
		Set<String> out  = new HashSet<String>();
		
		String ontime = "00:00";
		
		while((input = br.readLine()) != null) {
			String line[] = input.split(" ");
			
			String check = line[0];
			String name = line[1];
			//입장
			if(ontime.hashCode()<= check.hashCode() && check.hashCode() <=s.hashCode()) {
				enter.add(name);
			}
			if(check.hashCode()>=e.hashCode() && check.hashCode() <= q.hashCode()) {
				out.add(name);
			}
			
			
		}
		
		Set<String> answer = new HashSet<String>();
		answer.addAll(enter);
		answer.retainAll(out);
		
		System.out.println(answer.size());
		Iterator iter = answer.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		
	}
}
