import java.util.*;
public class Main_1769 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		int sum = 0;
		int count = 0;
		String num = input;
		
		while (num.length() != 1) {
			
			count++;
			sum = 0;
			
			for (int i = 0; i < num.length(); i++) {
				sum += (num.charAt(i) - 48);
			}
			
			num = String.valueOf(sum);
			
		}
		
		int result = Integer.parseInt(num);
		
		System.out.println(count);
		if (result == 3 || result == 6 || result == 9) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

}
