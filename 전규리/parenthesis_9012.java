package boj;

import java.util.*;

public class parenthesis_9012 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int len = sc.nextInt();

		for (int i = 0; i < len; i++) {
			ArrayList<String> list = new ArrayList<>(Arrays.asList(sc.next().split("")));
			System.out.println(remove(list));
		}
	}

	public static String remove(ArrayList<String> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).contains("(")) {
				for (int j = i+1; j < list.size(); j++) {
					if (list.get(j).contains(")")) {
						list.set(i,"0");
						list.set(j,"0");
						break;
					}
				}

			}
		}
		if (list.contains("(") == false && list.contains(")") == false) {
			return "YES";
		} else {
			return "NO";
		}
	}

}
