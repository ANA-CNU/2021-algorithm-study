package algorithm;

import java.io.*;
import java.util.*;

public class Q1244 {

	static boolean[] status;

	public static boolean[] changeStatus(boolean[] status, int sex, int position) {

		int tmp = 1;
		int boyTmp = position - 1;

		if (sex == 1) { // 성별이 남학생
			while (status.length > boyTmp) {

				status[boyTmp] = !status[boyTmp];
				tmp++;
				boyTmp = position * tmp - 1;
			}
		} else { // 여학생
			position -= 1;
			status[position] = !status[position];
			while (true) {
				if ((position - tmp) < 0 || (position + tmp) > status.length - 1)
					break;
				if (status[position - tmp] != status[position + tmp])
					break;
				status[position - tmp] = !status[position - tmp];
				status[position + tmp] = !status[position + tmp];
				tmp++;

			}
		}
		return status;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int number = Integer.parseInt(br.readLine()); // 스위치 개수
		status = new boolean[number]; // 스위치 상태 : 켜지면 1 (true), 꺼지면 0 (false)
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < number; i++) {
			if (st.nextToken().equals("1"))
				status[i] = true;
		}
		int student = Integer.parseInt(br.readLine());
		for (int i = 0; i < student; i++) {

			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int position = Integer.parseInt(st.nextToken());
			status = changeStatus(status, sex, position);

		}

		StringBuffer sb = new StringBuffer();

		int line = 0;

		for (int k = 0; k < status.length; k++) {
			if (status[k])
				sb.append("1 ");
			else
				sb.append("0 ");
			line++;
			if(line == 20) {
				sb.append("\n");
				line = 0;
			}
		}
		System.out.println(sb);

	}
}
