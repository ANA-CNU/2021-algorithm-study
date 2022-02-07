package Q_2776_암기왕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int note[];
	static StringBuilder sb = new StringBuilder();
	static Map<Integer, Integer> noteMap;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int test = Integer.parseInt(st.nextToken());
		int n, m;

		for (int i = 0; i < test; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			note = new int[n];
			noteMap = new HashMap<>();

			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				note[j] = num;
				if (!noteMap.containsKey(num))
					noteMap.put(num, 1);
			}

			Arrays.sort(note);

			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int num = Integer.parseInt(st.nextToken());
				binarySearch(num);
			}
		}

		System.out.print(sb);
	}

	public static void binarySearch(int num) {
		int st, ed, mid;
		st = 0;
		ed = note.length - 1;
		while (st <= ed) {
			mid = (st + ed) / 2;
			if (noteMap.containsKey(num)) {
				sb.append(1 + "\n");
				return;
			} else if (note[mid] > num)
				ed = mid - 1;
			else
				st = mid + 1;
		}
		sb.append(0 + "\n");
	}
}

// 시간초과 코드
//public class Main {
//	public static void main(String args[]) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int t = Integer.parseInt(br.readLine());
//		
//		while (t-- > 0) {
//			int cnt_1 = Integer.parseInt(br.readLine());
//			Set<Integer> set_1 = new TreeSet<Integer>();
//			Set<Integer> set_2 = new HashSet<Integer>();
//			String input[] = br.readLine().split(" ");
//			for (int i = 0; i < cnt_1; i++) {
//				
//				int memo_1 = Integer.parseInt(input[i]);
//				set_1.add(memo_1);
//			}
//			
//			int arr [] = new int[set_1.size()];
//			int aa = 0;
//			for(int idx : set_1) {
//				arr[aa] = idx;
//				aa++;
//			}
//			
//			int cnt_2 = Integer.parseInt(br.readLine());
//			input = br.readLine().split(" ");
//			for (int i = 0; i < cnt_2; i++) {
//				
//				int memo_2 = Integer.parseInt(input[i]);
//				if(binarySearch(memo_2, arr)) {
//					System.out.println("1");
//				}else {
//					System.out.println("0");
//				}
//	
//			}
//
//		}
//
//	}
//	
//	
//	private static boolean  binarySearch(int ikey, int arr[]) {
//		int mid;
//		int left = 0;
//		int right = arr.length-1;
//		while(right >= left) {
//			mid = (right + left)/2;
//			
//			if(ikey == arr[mid]) {
//				return true;
//			}
//			
//			if(ikey < arr[mid]) {
//				right = mid-1;
//			}else {
//				left = mid+1;
//			}
//		}
//		return false;
//	}
//}


 