package beakjoon;

import java.util.Scanner;
import java.util.Stack;

public class 괄호_끼워넣기 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
    	
    	String str[] = sc.nextLine().split("");
    	
    	Stack s = new Stack();
    	int count=0;
    	for(int i=0; i<str.length; i++) {
    		if(str[i].equals("(")) {
    			s.push("(");
    		}
    		else {
    			if(s.isEmpty()) {
    				count++;
    			}
    			else {
    				s.pop();    				
    			}
    		}
    	}
    	
    	if(!s.isEmpty()) {
    		count += s.size();
    	}
    	
    	System.out.println(count);
	}
}
