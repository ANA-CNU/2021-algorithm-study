import java.util.*;
import java.io.*;

public class N_1292 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int start = Integer.parseInt(input[0]);
		int end = Integer.parseInt(input[1]);
		List<Integer> list = new ArrayList<>();
		for(int i = 1; i<=end;i++){
			for(int j = 0; j<i; j++){
				list.add(i);
			}
		}
		int answer = 0;
		for(int i = start-1; i<end; i++){
			answer += list.get(i);
		}
		System.out.println(answer);

	}

}
