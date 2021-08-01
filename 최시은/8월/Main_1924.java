import java.util.Scanner;

public class Main_1924 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] dayoftheweek = { "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN" };
		int dayday = 0;
		int month = 1;
		int day = 1;

		int input_month = sc.nextInt();
		int input_day = sc.nextInt();

		while (true) {

			if (month == input_month && day == input_day) {
				System.out.println(dayoftheweek[dayday]);
				break;
			}

			day++;
			dayday++;

			if (dayday == 7) {
				dayday = 0;
			}

			if ((month == 4 || month == 6 || month == 9 || month == 11) && day == 31) {
				month++;
				day = 1;
			} else if (month == 2 && day == 29) {
				month++;
				day = 1;
			} else if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10)
					&& day == 32) {
				month++;
				day = 1;
			}

		}

	}

}
