import java.util.*;
import java.io.*;

public class FindPassword_17219 {

	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int sl = Integer.parseInt(st.nextToken());
		int pl = Integer.parseInt(st.nextToken());
		
		ArrayList<String> _f = new ArrayList<>();
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		for (int i = 0; i < sl; i++) {
			String[] val = br.readLine().split(" ");
			map.put(val[0], val[1]);
		}
		
		for (int i = 0; i < pl; i++) {
			_f.add(br.readLine());
		}
		
		for (int i = 0; i < pl; i++) {
			bw.write(map.get(_f.get(i))+"\n");
		}
		
		bw.flush();
		bw.close();
	}
}
