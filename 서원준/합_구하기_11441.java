package beakjoon;

import java.util.Scanner;

public class 합_구하기_11441 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
    	StringBuilder sb = new StringBuilder();
    	
    	int n = Integer.parseInt(sc.nextLine());
    	
    	int arr[] = new int[n+1];
    	for(int i=1; i<arr.length; i++) {
    		arr[i] = sc.nextInt();
    	}
    	
    	int sum[] = new int[n+1];
    	
    	for(int i=0; i<sum.length-1; i++) {
    		sum[i+1] = sum[i] + arr[i+1];
    	}
    	
    	
    	sc.nextLine();
    	int m = Integer.parseInt(sc.nextLine());

    	
    	for(int i=0; i<m; i++) {
    		String str[] = sc.nextLine().split(" ");
    		int a = Integer.parseInt(str[0]);
    		int b = Integer.parseInt(str[1]);
        	
        	int result = 0;
        	result = sum[b]-sum[a-1];
        	sb.append(result+"\n");
    	}
    		
    	System.out.println(sb);

	}

}
