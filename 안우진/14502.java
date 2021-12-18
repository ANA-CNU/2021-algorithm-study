import java.io.*;
import java.util.*;

public class BOJ {

    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,1,-1};
    static int[][] map;
    static ArrayList<int[]> virus;
    static int N,M;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        virus = new ArrayList<>();
        String[] tmp = br.readLine().split(" ");
        N = Integer.parseInt(tmp[0]); M = Integer.parseInt(tmp[1]);
        map = new int[N][M];
        for(int i=0; i<N; i++){
            tmp = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(tmp[j]);
                if(map[i][j]==2){
                    virus.add(new int[]{i,j});
                }
            }
        }
        wall(0);
        System.out.println(ans);

    }

    static void dfs(){
        int[][] vMap = new int[N][M];
        for(int y=0; y<N; y++){
            for(int x=0; x<M; x++){
                vMap[y][x] = map[y][x];
            }
        }
        Queue<int[]> q = new LinkedList<>();
        for(int[] v : virus){
            q.offer(v);
        }
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int y = tmp[0];
            int x = tmp[1];
            for(int i=0; i<4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(Range(ny, nx) && vMap[ny][nx] == 0){
                    vMap[ny][nx] = 2;
                    q.offer(new int[]{ny,nx});
                }
            }
        }
        int res = 0;
        for(int y=0; y<N; y++){
            for(int x=0; x<M; x++){
                if(vMap[y][x] == 0){
                    res+=1;
                }
            }
        }
        ans=Math.max(ans, res);
    }

    static boolean Range(int y, int x) {return 0 <= y && y < N && 0 <= x && x < M;}

    static void wall(int cnt){
        if(cnt==3){
            dfs();
            return;
        }
        for(int y=0; y<N; y++){
            for(int x=0; x<M; x++){
                if(map[y][x] == 0){
                    map[y][x]=1;
                    wall(cnt+1);
                    map[y][x]=0;
                }

            }
        }
    }
}
