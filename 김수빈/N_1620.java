import java.util.*;
import java.io.*;

public class N_1620 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(input[0]);
		int Q = Integer.parseInt(input[1]);
		Map<Integer, String> NUM = new HashMap<>();
		Map<String, Integer> STRING = new HashMap<>();
		for(int i = 1; i<=N; i++){
			String in = br.readLine();
			NUM.put(i, in);
			STRING.put(in, i);
		}
		for(int i = 0; i<Q; i++){
			String in = br.readLine();
			if(Character.isDigit(in.charAt(0))){
				sb.append(NUM.get(Integer.parseInt(in))+"\n");
			}else{
				sb.append(STRING.get(in)+"\n");
			}
		}
		System.out.println(sb.toString());
	}

}
