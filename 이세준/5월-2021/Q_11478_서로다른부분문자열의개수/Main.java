package Q_11478_서로다른부분문자열의개수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		Set<String> set = new HashSet<String>();
		String temp = "";
		for(int i = 0; i < input.length();i++) {
			temp = "";
			for(int j = i ; j<input.length();j++) {
				temp += input.substring(j,j+1);
				set.add(temp);
			}
		}
		
		System.out.println(set.size());
	}
}
