package beakjoon;

import java.util.Scanner;

public class 제곱수의_합_1699 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
    	
    	int n = Integer.parseInt(sc.nextLine());
    	int arr[] = new int[n+1];
    	
    	for(int i=1; i<=n; i++) {
    		arr[i]=i;
    	}
    	
    	for(int i=2; i<=n; i++) {
    		for(int j=2; j*j<=i; j++) {
        		arr[i] = Math.min(arr[i], arr[i-j*j]+1);
        	}
    	}
    	
    	System.out.println(arr[n]);

	}

}
