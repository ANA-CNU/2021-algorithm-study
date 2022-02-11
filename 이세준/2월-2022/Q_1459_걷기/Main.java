package Q_1459_걷기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input [] = br.readLine().split(" "); //x y w s 
		
		long x = Long.parseLong(input[0]);
		long y = Long.parseLong(input[1]);
		int w = Integer.parseInt(input[2]);
		int s = Integer.parseInt(input[3]);
		
		long result = 0;
		long con = 0;
		while(true) {
			if(x == 0 || y ==0) {
				if(x == 0) {
					con = y;
				}else {
					con = x;
				}
				break;
			}
			if(2*w <=s) {
				if(x<=y) {
					x-=1;
					result +=w;
				}else {
					y-=1;
					result+=w;
				}
				
				
			}else {
				x-=1;
				y-=1;
				result+=s;
	
			}
			if(x == 0 || y ==0) {
				if(x == 0) {
					con = y;
				}else {
					con = x;
				}
				break;
			}
		}

	
		if(con%2==0) {
			
		
		if(con*w>=con*s) {
			result+=con*s;
		}else {
			result+=con*w;
		}
		
		
		}else {
			if(con==1) {
				result+=w;
			}else {
				if(2*w<=s) {
					result+=con*w;
				}else {
					result+=(con-1)*s +w;
					
					
					
				}
				
				
			}
			
			
			
			
			
			
		}
		
		System.out.println(result);
		
		
		
	}
}
