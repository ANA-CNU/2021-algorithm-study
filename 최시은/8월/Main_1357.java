import java.util.Scanner;

public class Main_1357 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Rev rev = new Rev();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int result = rev.Reverse(rev.Reverse(a) + rev.Reverse(b));
		System.out.println(result);

	}

}

class Rev {
	
	int Reverse (int num) {
		String str = String.valueOf(num);
		String rev = "";
		boolean zero = false;
		
		for (int i = str.length() - 1; i >= 0; i--) {
			if (str.charAt(i) == 48 && zero == false) {
				continue;
			} else if (str.charAt(i) != 48 && zero == false) {
				zero = true;
				rev += (str.charAt(i) - 48);
			} else {
				rev += (str.charAt(i) - 48);
			}
		}
		
		int result = Integer.parseInt(rev);
		
		return result;
	}
}