package beakjoon;

import java.util.Scanner;
import java.util.Stack;

public class Main_10773 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		String n = sc.nextLine();
		Stack<Integer> s = new Stack<>();
		
		for(int i=0; i<Integer.parseInt(n); i++) {
			String input = sc.nextLine();
			if(Integer.parseInt(input)!=0) {
				s.push(Integer.parseInt(input));
			}
			else {
				s.pop();
			}
		}
		
		int sum=0;
		int c = s.size();
		for(int i=0; i<c; i++) {
			sum += s.pop();
		}
		System.out.println(sum);

	}

}
