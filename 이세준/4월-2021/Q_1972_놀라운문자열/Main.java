package Q_1972_놀라운문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		String input = "";
		while(!(input = br.readLine()).equals("*")) {
			ArrayList<String> list = new ArrayList<>();
			int len = input.length();
			boolean isSurprise = true;
			
			for(int i =1; i < len ; i++) {
				list.clear();
				for(int j =0; j < len -i;j++) {
					String str = Character.toString(input.charAt(j)) + Character.toString(input.charAt(j+i));
					list.add(str);
				}
				Collections.sort(list);
				for(int k  = 0; k < list.size()-1; k++) {
					if(list.get(k).equals(list.get(k+1))) {
						isSurprise = false;
						break;
					}
				}
				
				if(!isSurprise) {
					break;
				}
				
			}
			if(isSurprise) {
				sb.append(input).append(" is surprising.");
			}else {
				sb.append(input).append(" is Not surprising.");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
}
