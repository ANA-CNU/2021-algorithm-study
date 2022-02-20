package Q_1114_통나무자르기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input [] =br.readLine().split(" ");
		Long l = Long.parseLong(input[0]);
		int k = Integer.parseInt(input[1]);
		int c = Integer.parseInt(input[2]);
		
		input = br.readLine().split(" ");
		List<Long> pos = new ArrayList<>();
		pos.add(0L);
		pos.add(l);
		
		for(int i =0; i<k;i++) {
			pos.add(Long.parseLong(input[i]));
		}
		
		pos.sort((a,b)-> (int) (a-b));
		long left =0;
		long right = l;
		long ansFirst =0;
		long ansLongest =l;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long cutCnt = 0;
            long firstCut = -1;
            long diff = 0;
            for (int i = k; i >= 0; i--) {
                diff += pos.get(i + 1) - pos.get(i);
                if (diff > mid) {
                    diff = pos.get(i + 1) - pos.get(i);
                    cutCnt++;
                    if (diff > mid) {
                        cutCnt = c + 1;
                        break;
                    }
                }
            }
		
            if (cutCnt < c) {
                firstCut = pos.get(1);
            } else {
                firstCut = diff;
            }
            if (cutCnt <= c) {
                ansLongest = Math.min(mid, ansLongest);
                ansFirst = firstCut;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
		
        }
        System.out.println(ansLongest + " " + ansFirst);
	}
}
