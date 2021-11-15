package beakjoon;

import java.util.Scanner;

public class _0의_개수_11170 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
    	
    	int n = Integer.parseInt(sc.nextLine());
    	
    	for(int i=0; i<n; i++) {
    		String input[] = sc.nextLine().split(" ");
    		int a = Integer.parseInt(input[0]);
    		int b = Integer.parseInt(input[1]);
    		int count=0;
    		
    		
    		for(int j=a; j<=b; j++) {
    			String s = String.valueOf(j);
    			for(int k=0; k<s.length(); k++) {
    				if(s.charAt(k) == '0') {
    					count++;
    				}
    			}
    			
    		}
    		System.out.println(count);
    	}
		

	}

}
