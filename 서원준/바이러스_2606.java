package beakjoon;

import java.util.Scanner;

public class 바이러스_2606 {
	static boolean check[][] = new boolean[101][101];
	static boolean visited[] = new boolean[101];
    static int n;
    static int m;
    static int count=0;
    
    static void dfs(int s) {
    	visited[s] = true;
    	count++;
    	
    	for(int i=0; i<n+1; i++) {
			if(check[s][i]==true && visited[i]==false) {
				dfs(i);
			}
		}	
	}
    
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	n = Integer.parseInt(sc.nextLine());
    	m = Integer.parseInt(sc.nextLine());
    	
    	for(int i=0; i<m; i++) {
    		String str[] = sc.nextLine().split(" ");
    		int x = Integer.parseInt(str[0]);
    		int y = Integer.parseInt(str[1]);
    		
    		check[x][y] = check[y][x] =true;
    	}
    	dfs(1);
    	System.out.println(count-1);
    }
}
