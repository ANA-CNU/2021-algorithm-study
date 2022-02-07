package Q_3077_임진왜란;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String args[]) throws Exception {
	BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
	
	int n = Integer.parseInt(br.readLine());
	
	String input_question []= br.readLine().split(" ");
	Map<String,Integer> q_map = new HashMap<String, Integer>();
	
	for(int i = 0; i < n; i++) {
		q_map.put(input_question[i], i+1);
	}

	String input_answer [] = br.readLine().split(" ");

//	Map<String,Integer> a_map = new HashMap<String, Integer>();
//	
//	for(int i = 0; i < n; i++) {
//		a_map.put(input_answer[i], i+1);
//	}
//	
	int cnt = 0;
	
	for(int i = 0; i < n-1;i++) {
		for(int j = i+1;j<n;j++) {
			if(q_map.get(input_answer[i]) < q_map.get(input_answer[j]) ) {
				cnt++;
			}
		}
	}
	
	int all = n*(n-1)/2;
	System.out.println(cnt+"/"+all);
	
	}
}
