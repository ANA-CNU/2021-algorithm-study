package beakjoon;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AC_5430 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
    	
    	int n = Integer.parseInt(sc.nextLine());
    	StringBuffer sb = new StringBuffer();
    	
    	for(int j=0; j<n; j++) {
    		boolean check = true;
    		boolean error = true;
        	
        	String f = sc.nextLine();
        	
        	int len = Integer.parseInt(sc.nextLine());
        	
        	String str = sc.nextLine();
        	str = str.substring(1,str.length()-1);
        	StringTokenizer st = new StringTokenizer(str, ",");
        	
        	Deque<Integer> d = new LinkedList<>();
        	
        	for(int i=0; i<len; i++) {
        		d.add(Integer.parseInt(st.nextToken()));
        	}
        	
        	
        	for(int i=0; i<f.length(); i++) {
        		if(f.charAt(i)=='R') {
        			check = !check;
        		}
        		
        		if(f.charAt(i)=='D') {
        			if(d.isEmpty()) {
        				error = false;
        				break;
        			}
        			else {
        				if(check) {
            				d.pollFirst();
            			}
            			else {
            				d.pollLast();
            			}
        			}
        		}
        	}
        	
        	if(error) {
        		int s = d.size();
        		if(check) {
        			sb.append("[");
        			for(int i=0; i<s; i++) {
        				if(i!=s-1) {
        					sb.append(d.pollFirst()+",");					
        				}
        				else {
        					sb.append(d.pollFirst());
        				}
        			}
        			sb.append("]\n");
        		}
        		else {
        			sb.append("[");
        			for(int i=0; i<s; i++) {
        				if(i!=s-1) {
        					sb.append(d.pollLast()+",");					
        				}
        				else {
        					sb.append(d.pollLast());
        				}
        			}
        			sb.append("]\n");
        		}
        	}
        	else {
        		sb.append("error\n");
        	}
        	
    	}
    	
    	System.out.println(sb);

	}

}
