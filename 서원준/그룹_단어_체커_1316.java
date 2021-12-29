package beakjoon;

import java.util.Scanner;

public class 그룹_단어_체커_1316 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		
		int cnt=0;
		for(int j=0; j<n; j++) {
			String arr[] = sc.nextLine().split("");
			String z="";
			boolean check = true;
			
			for(int i=0; i<arr.length-1; i++) {
				z+=arr[i];
				if(arr[i].equals(arr[i+1])) {

				}
				else {
					if(z.contains(arr[i+1])) {
						check=false;
					}
				}
			}
			if(check==true) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
