package winter2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N + M; i++) {
            String str = br.readLine();
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        ArrayList<String> arr = new ArrayList<>();
        int count = 0;
        for(String str : map.keySet()){
            if(map.get(str) >= 2){
                arr.add(str);
                count++;
            }
        }
        Collections.sort(arr);

        System.out.println(count);
        for(String a : arr){
            System.out.println(a);
        }
    }
}
