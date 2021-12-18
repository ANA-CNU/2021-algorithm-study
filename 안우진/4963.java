import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int h,w,ans;
    static int[][] map;
    static final int[] dy = {0,0,1,-1,1,1,-1,-1};
    static final int[] dx = {1,-1,0,0,1,-1,1,-1};
    static Queue<int[]> q;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp;
        q = new LinkedList<>();

        while(true){
            tmp = br.readLine().split(" ");
            if(tmp[0].equals("0")) break;
            q.clear();
            w = Integer.parseInt(tmp[0]); h = Integer.parseInt(tmp[1]);
            map = new int[h][w];
            for(int i=0; i<h; i++){
                tmp=br.readLine().split(" ");
                for(int j=0; j<w; j++){
                    map[i][j] = Integer.parseInt(tmp[j]);
                }
            }
            ans=0;
            bfs();
            System.out.println(ans);
        }
    }

    static void bfs(){
        q.offer(new int[] {-1,-1});
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int y = tmp[0]; int x = tmp[1];
            for(int i=0; i<8; i++){
                int ny = y + dy[i]; int nx = x + dx[i];
                if(!Range(ny,nx) || map[ny][nx]==-1) continue;
                if(map[ny][nx]==1){
                    map[ny][nx]=-1;
                    ans+=1;
                    dfs(ny,nx);
                }else{
                    map[ny][nx]=-1;
                }
                q.add(new int[]{ny,nx});
            }
        }
    }

    static void dfs(int y, int x){
        for(int i=0; i<8; i++) {
            int ny = y + dy[i]; int nx = x + dx[i];
            if (Range(ny, nx)) {
                if(map[ny][nx] == 1){
                    map[ny][nx]=-1;
                    dfs(ny,nx);
                }else{
                    map[ny][nx]=-1;
                    q.offer(new int[]{ny,nx});
                }
            }
        }
    }

    static boolean Range(int y, int x){
        return 0<=y&&y<h&&0<=x&&x<w;
    }
}
