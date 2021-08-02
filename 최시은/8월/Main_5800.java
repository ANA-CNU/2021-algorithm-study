import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Main_5800 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String classs = sc.nextLine();
		int class_num = Integer.parseInt(classs);
		
		for (int i = 1; i <= class_num; i++) {
			String input = sc.nextLine();
			String[] arr = input.split(" ");
			int classmates = Integer.parseInt(arr[0]);
			
			Integer[] grade = new Integer[classmates];
			
			for (int j = 0; j < classmates; j++) {
				grade[j] = Integer.parseInt(arr[j + 1]);
				
			}
			
			Arrays.sort(grade, Comparator.reverseOrder());
			int max = grade[0];
			int min = grade[classmates - 1];
			int gap = 0;
			
			for (int k = 0; k < classmates - 1; k++) {
				if (grade[k] - grade[k + 1] > gap) {
					gap = grade[k] - grade[k + 1];
				} else {
					continue;
				}
			}
			
			System.out.println("Class " + i);
			System.out.println("Max " + max + ", Min " + min + ", Largest gap " + gap);
			
		}

	}

}
