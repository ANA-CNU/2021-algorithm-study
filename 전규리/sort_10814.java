import java.util.*;
import java.io.*;

public class sort_10814 {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int len = Integer.parseInt(br.readLine());
		
		String arr[][] = new String[len][2];
		
		for (int i = 0; i < len; i++) {
			String val[] = br.readLine().split(" ");
			
			arr[i][0] = val[0];
			arr[i][1] = val[1];
		}
		
		Arrays.sort(arr, new Comparator<String []>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				if (Integer.parseInt(o1[0]) < Integer.parseInt(o2[0])) {
					return -1;
				} else if (Integer.parseInt(o1[0]) > Integer.parseInt(o2[0])) {
					return 1;					
				} else {
					return 0;
				}
			}
			
		});
	
		for (int i = 0; i < len; i++) {
			bw.write(arr[i][0] + " " + arr[i][1] + "\n");
		}
		bw.flush();
		bw.close();
	}
}
