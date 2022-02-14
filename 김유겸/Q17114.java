package winter2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class HyperTomato {
    int a;
    int b;
    int c;
    int d;
    int e;
    int f;
    int g;
    int h;
    int i;
    int j;
    int k;

    HyperTomato(int a, int b, int c, int d, int e, int f, int g, int h, int i, int j, int k) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
        this.k = k;
    }
}

public class Q17114 {
    static int[][][][][][][][][][][] board;
    static Queue<HyperTomato> Q;
    static int[] da = {1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static int[] db = {0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static int[] dc = {0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static int[] dd = {0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static int[] de = {0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static int[] df = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static int[] dg = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0};
    static int[] dh = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, 0};
    static int[] di = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0, 0, 0};
    static int[] dj = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, 0, 0};
    static int[] dk = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1};
    static int aaa, bbb, ccc, ddd, eee, fff, ggg, hhh, iii, jjj, kkk, answer = 0;

    static void BFS() {
        while (!Q.isEmpty()) {
            HyperTomato t = Q.poll();
            int a = t.a;
            int b = t.b;
            int c = t.c;
            int d = t.d;
            int e = t.e;
            int f = t.f;
            int g = t.g;
            int h = t.h;
            int i = t.i;
            int j = t.j;
            int k = t.k;

            for (int q = 0; q < 22; q++) {
                int na = a + da[q];
                int nb = b + db[q];
                int nc = c + dc[q];
                int nd = d + dd[q];
                int ne = e + de[q];
                int nf = f + df[q];
                int ng = g + dg[q];
                int nh = h + dh[q];
                int ni = i + di[q];
                int nj = j + dj[q];
                int nk = k + dk[q];

                if (na >= 0 && na < aaa && nb >= 0 && nb < bbb && nc >= 0 && nc < ccc && nd >= 0 && nd < ddd && ne >= 0 && ne < eee && nf >= 0 && nf < fff && ng >= 0 && ng < ggg && nh >= 0 && nh < hhh && ni >= 0 && ni < iii && nj >= 0 && nj < jjj && nk >= 0 && nk < kkk && board[na][nb][nc][nd][ne][nf][ng][nh][ni][nj][nk] == 0) {
                    Q.offer(new HyperTomato(na, nb, nc, nd, ne, nf, ng, nh, ni, nj, nk));
                    board[na][nb][nc][nd][ne][nf][ng][nh][ni][nj][nk] = board[a][b][c][d][e][f][g][h][i][j][k] + 1;
                }
            }
        }


        for (int tk = 0; tk < kkk; tk++) {
            for (int tj = 0; tj < jjj; tj++) {
                for (int ti = 0; ti < iii; ti++) {
                    for (int th = 0; th < hhh; th++) {
                        for (int tg = 0; tg < ggg; tg++) {
                            for (int tf = 0; tf < fff; tf++) {
                                for (int te = 0; te < eee; te++) {
                                    for (int td = 0; td < ddd; td++) {
                                        for (int tc = 0; tc < ccc; tc++) {
                                            for (int tb = 0; tb < bbb; tb++) {
                                                for (int ta = 0; ta < aaa; ta++) {
                                                    answer = Math.max(answer, board[ta][tb][tc][td][te][tf][tg][th][ti][tj][tk]);
                                                    if (board[ta][tb][tc][td][te][tf][tg][th][ti][tj][tk] == 0) {
                                                        answer = -1;
                                                        return;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        answer -= 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        aaa = Integer.parseInt(st.nextToken());
        bbb = Integer.parseInt(st.nextToken());
        ccc = Integer.parseInt(st.nextToken());
        ddd = Integer.parseInt(st.nextToken());
        eee = Integer.parseInt(st.nextToken());
        fff = Integer.parseInt(st.nextToken());
        ggg = Integer.parseInt(st.nextToken());
        hhh = Integer.parseInt(st.nextToken());
        iii = Integer.parseInt(st.nextToken());
        jjj = Integer.parseInt(st.nextToken());
        kkk = Integer.parseInt(st.nextToken());

        board = new int[aaa][bbb][ccc][ddd][eee][fff][ggg][hhh][iii][jjj][kkk];
        Q = new LinkedList();


        for (int tk = 0; tk < kkk; tk++) {
            for (int tj = 0; tj < jjj; tj++) {
                for (int ti = 0; ti < iii; ti++) {
                    for (int th = 0; th < hhh; th++) {
                        for (int tg = 0; tg < ggg; tg++) {
                            for (int tf = 0; tf < fff; tf++) {
                                for (int te = 0; te < eee; te++) {
                                    for (int td = 0; td < ddd; td++) {
                                        for (int tc = 0; tc < ccc; tc++) {
                                            for (int tb = 0; tb < bbb; tb++) {
                                                st = new StringTokenizer(br.readLine());
                                                for (int ta = 0; ta < aaa; ta++) {
                                                    board[ta][tb][tc][td][te][tf][tg][th][ti][tj][tk] = Integer.parseInt(st.nextToken());
                                                    if (board[ta][tb][tc][td][te][tf][tg][th][ti][tj][tk] == 1) {
                                                        Q.offer(new HyperTomato(ta, tb, tc, td, te, tf, tg, th, ti, tj, tk));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        BFS();
        System.out.println(answer);
    }
}


