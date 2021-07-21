import java.util.*;
import java.io.*;

public class N_11723 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Set<Integer> set = new HashSet<>();
		Set<Integer> addALL = new HashSet<>();
		for(int i = 1; i<=20; i++){
			addALL.add(i);
		}
		for(int i = 0; i<N; i++){
			String[] input = br.readLine().split(" ");
			if(input[0].equals("all")){
				set.addAll(addALL);
			}else if(input[0].equals("empty")){
				set.removeAll(addALL);
			}else{
				int num = Integer.parseInt(input[1]);
				if(input[0].equals("add")){
					if(!set.contains(num)){
						set.add(num);
					}
				}else if(input[0].equals("remove")){
					if(set.contains(num)){
						set.remove(num);
					}
				}else if(input[0].equals("check")){
					if(set.contains(num)){
						sb.append(1+"\n");
					}else{
						sb.append(0+"\n");
					}
				}else if(input[0].equals("toggle")){
					if(set.contains(num)){
						set.remove(num);
					}else{
						set.add(num);
					}
				}
			}
		}
		System.out.println(sb.toString());

	}

}