package beakjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 나이순_정렬_10814 {
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int n = Integer.parseInt(sc.nextLine());
    	String arr[][] = new String[n][2];
    	
    	for(int i=0; i<n; i++) {
    		String tmp[] = sc.nextLine().split(" ");
    		arr[i][0] = tmp[0];
    		arr[i][1] = tmp[1];
    		}
    	
    	Arrays.sort(arr, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				// TODO Auto-generated method stub
				if(o1[0]==o2[1]) {
					return 1;
				}
				else {
					return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
				}
			}
    	});
    	
    	for(int i=0; i<n; i++) {
    		System.out.println(arr[i][0]+" "+arr[i][1]);
    	}
    }
}
