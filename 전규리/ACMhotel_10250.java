package boj;

import java.util.*;
import java.io.*;

public class ACMhotel_10250 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int len = sc.nextInt();
		
		for (int i = 0; i < len; i++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			int n = sc.nextInt();
			
			String _h;
			String _w;
			if (h >= n) {
				_h = Integer.toString(n);
				_w = Integer.toString(1);
			} else {
				if (n % h == 0) {
					_h = Integer.toString(h);
					_w = Integer.toString((n / h));
				} else {
					_h = Integer.toString(n % h);
					_w = Integer.toString((n / h)+1);
				}
			}
			
			_w = (_w.length() < 2) ? "0"+_w : _w; 
			
			System.out.println(_h+_w);
		}
	}
}
