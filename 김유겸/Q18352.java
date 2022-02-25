package winter2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q18352 {
    static int[] distance;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());//도시의 개수
        int M = Integer.parseInt(st.nextToken());//도로의 개수
        int K = Integer.parseInt(st.nextToken());//거리 정보
        int X = Integer.parseInt(st.nextToken());//출발 도시의 정보

        graph = new ArrayList<>();
        distance = new int[N + 1];
        for (int i = 1; i < distance.length; i++) distance[i] = Integer.MAX_VALUE;

        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph.get(v1).add(v2);
        }

        BFS(X);

        boolean isExist = false;
        for (int i = 1; i < distance.length; i++) {
            if (distance[i] == K) {
                System.out.println(i);
                isExist = true;
            }
        }
        if (!isExist) System.out.println(-1);
    }

    static void BFS(int X) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(X);
        distance[X] = 0;
        while (!Q.isEmpty()) {
            int cv = Q.poll();
            for (int i = 0; i < graph.get(cv).size(); i++) {
                int nv = graph.get(cv).get(i);
                if (distance[nv] >= distance[cv] + 1) {
                    distance[nv] = distance[cv] + 1;
                    Q.offer(nv);
                }
            }
        }
    }
}