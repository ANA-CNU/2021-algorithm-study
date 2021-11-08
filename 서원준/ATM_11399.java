package beakjoon;

import java.util.Arrays;
import java.util.Scanner;

public class ATM_11399 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
    	
    	String n = sc.nextLine();
    	int arr[] = new int[Integer.parseInt(n)];
    	
    	for(int i=0; i<Integer.parseInt(n); i++) {
    		arr[i] = sc.nextInt();
    	}
    	
    	Arrays.sort(arr);
    	
    	int sum=0;
    	for(int i=0; i<Integer.parseInt(n); i++) {
    		if(i!=0) {
    			arr[i] = arr[i]+arr[i-1];
    		}
    	}
    	
    	for(int s : arr) {
    		sum+=s;
    	}
    	System.out.println(sum);

	}

}
