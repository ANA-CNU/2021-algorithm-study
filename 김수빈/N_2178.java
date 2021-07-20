import java.util.*;

class cell{
	int x;
	int y;
	int day;
	
	public cell(int x, int y, int day){
		this.x = x;
		this.y = y;
		this.day = day;
	}
}
public class N_2178 {
	static int[] mx ={-1,1,0,0};
	static int[] my ={0,0,-1,1};

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int[][] miro = new int[N][M];
		boolean[][] visit = new boolean[N][M];
		visit[0][0] = true;
		Queue<cell> q = new LinkedList<>();
		
		for(int i = 0; i<N; i++){
			input = scan.nextLine().split("");
			for(int j = 0; j<M; j++){
				miro[i][j] = Integer.parseInt(input[j]);
			}
		}
		q.add(new cell(0,0,1));
		boolean check = true;
		while(!q.isEmpty()){
			cell c = q.poll();
			if(c.x==N-1 && c.y==M-1){
				System.out.println(c.day);
				check = false;
				break;
			}
			for(int i = 0; i<4; i++){
				int dx = c.x + mx[i];
				int dy = c.y + my[i];
				if(dx>=0&&dx<N&&dy>=0&&dy<M&&!visit[dx][dy]&&miro[dx][dy]==1){
					visit[dx][dy] = true;
					q.add(new cell(dx,dy,c.day+1));
				}
			}
		}

	}

}