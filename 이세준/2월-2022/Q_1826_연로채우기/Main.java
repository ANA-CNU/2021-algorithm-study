package Q_1826_연로채우기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;


class FUEL{
	int dist , quantity;
	public FUEL(int dist, int quantity) {
		this.dist = dist;
		this.quantity = quantity;
	}
}


//최소값 구하기
public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<FUEL> distQ  = new PriorityQueue<>(Comparator.comparingInt(f -> f.dist));
		PriorityQueue<Integer> fuelQ = new PriorityQueue<> (Comparator.comparingInt(o -> -o));
		
		for(int i =0 ;i < n;i++) {
			String input [] = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]); //시작 위치에서의 거리
			int b = Integer.parseInt(input[1]); //연료의 양
			distQ.add(new FUEL(a, b));
	
		}
		
		String input[] = br.readLine().split(" ");
		
		int l = Integer.parseInt(input[0]); //성경이의 위치에서 마을까지 거리
		int p = Integer.parseInt(input[1]); //트럭에 원래 있던 연료의 양
		
		
		
		solve(l,p, distQ,fuelQ);

		
	}

	private static void solve(int END, int currentFuel, PriorityQueue<FUEL> distQ, PriorityQueue<Integer> fuelQ) {
		int answer =0;
		while(END > currentFuel) {
			if(distQ.isEmpty() && fuelQ.isEmpty()) {
				answer = -1;
				break;
			}
			
			if(fuelQ.isEmpty() && distQ.peek().dist > currentFuel) {
				answer = -1;
				break;
			}
			
			while(!distQ.isEmpty() && distQ.peek().dist<= currentFuel) {
				fuelQ.add(distQ.poll().quantity);
			}
			
			if(!fuelQ.isEmpty()) {
				currentFuel += fuelQ.poll();
				answer++;
			}
		}
		System.out.println(answer);
	}


}
