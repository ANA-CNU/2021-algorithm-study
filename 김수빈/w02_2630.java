import java.io.*;

public class w02_2630 {
	
	static int[][] A;
	static int count_W = 0;
	static int count_B = 0;
	
	static void cut(int[][] A,int x,int y,int size) {
		boolean check = false;
		int before = A[x][y];
		for(int i = x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				if(A[i][j]!=before) {
					check =true;
					break;
				}
				before = A[i][j];
			}
			if(check) {break;}
		}
		if(!check) {
			if(before==0) {
				count_W++;
			}else {
				count_B++;
			}
			return;
		}else {
			int n = size / 2;
			cut(A,x,y,n);
			cut(A,x+n,y,n);
			cut(A,x,y+n,n);
			cut(A,x+n,y+n,n);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		A = new int[N][N];
		for(int i = 0; i<N; i++) {
			String[] input = br.readLine().split(" ");
			for(int j=0;j<N; j++) {
				A[i][j] = Integer.parseInt(input[j]);
			}
		}
		cut(A,0,0,N);
		System.out.println(count_W);
		System.out.println(count_B);
		
		br.close();
	}

}
