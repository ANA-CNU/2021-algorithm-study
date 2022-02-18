package winter2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2110 {
    public static int[] house;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        house = new int[N];

        for(int i = 0; i < N; i++){
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);

        //거리기준
        int low = 1;
        int high = house[N-1] - house[0] + 1;

        System.out.println(binarySearch(low, high, C));
    }

    static int binarySearch(int low, int high, int C){
        int mid = 0;
        while (low <= high){
            mid = (high + low) / 2;
            if(installNum(mid) < C){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low - 1;
    }

    static int installNum(int dis){
        int lLocate = house[0];
        int count = 1;

        for(int i = 1; i < house.length; i++){
            int cLocate = house[i];

            if(cLocate - lLocate >= dis){
                count++;
                lLocate = cLocate;
            }
        }
        return count;
    }
}
