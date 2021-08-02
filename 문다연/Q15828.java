package algorithm;

import java.util.*;

public class Q15828 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int bufferSize = sc.nextInt();
		Queue<Integer> router = new LinkedList<Integer>();
		while (true) {
			int packet = sc.nextInt();
			if (packet == -1)
				break;
			if (packet == 0) {
				router.poll();
			} else {
				if (router.size() < bufferSize)
					router.add(packet);
			}
		}

		if (router.isEmpty())
			System.out.println("empty");
		else
			while (!router.isEmpty())
				System.out.print(router.poll() + " ");
	}
}
