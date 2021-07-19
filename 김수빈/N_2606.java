import java.util.*;

public class N_2606 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = Integer.parseInt(scan.nextLine());
		int K = Integer.parseInt(scan.nextLine());
		Map<Integer,List<Integer>> map = new HashMap<>();
		boolean[] visit = new boolean[N+1];
		for(int i = 1; i<=N; i++){
			List<Integer> list = new ArrayList<>();
			map.put(i, list);
		}
		for(int i = 0; i<K; i++){
			String[] input = scan.nextLine().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);
			map.get(start).add(end);
			map.get(end).add(start);
		}
		Queue<List<Integer>> q = new LinkedList<>();
		q.add(map.get(1));
		visit[1] = true;
		while(!q.isEmpty()){
			List<Integer> list = q.poll();
			for(int i = 0; i<list.size(); i++){
				if(!visit[list.get(i)]){
					visit[list.get(i)] = true;
					q.add(map.get(list.get(i)));
				}
			}
		}
		int count = 0;
		for(int i = 1; i<=N;i++){
			if(visit[i]){
				count++;
			}
		}
		System.out.println(count-1);
	}

}
