package beakjoon;

import java.util.Scanner;

public class 트리플소트_20309 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
    	
    	int n = Integer.parseInt(sc.nextLine());
    	
    	String arr[] = sc.nextLine().split(" ");
    	boolean check = true;
    	
    	for(int i=0; i<n; i++) {
    		if(Integer.parseInt(arr[i])%2==0 && i%2==0) {
    			check = false;
    			break;
    		}
    		else if(Integer.parseInt(arr[i])%2==1 && i%2==1) {
    			check = false;
    			break;
    		}
    	}
    	
    	if(check) {
    		System.out.println("YES");    		
    	}
    	else {
    		System.out.println("NO");    		
    	}

	}

}
