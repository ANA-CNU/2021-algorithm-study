import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws IOException {
        int len = Integer.parseInt(br.readLine());
        String[] data = br.readLine().split(" ");
        long[] beforeSort = new long[len];
        long[] afterSort = new long[len];

        HashMap<Long, Long> map = new HashMap<>();

        for(int i = 0; i < len; i++){
            beforeSort[i] = Integer.parseInt(data[i]);
            afterSort[i] = Integer.parseInt(data[i]);
        }

        Arrays.sort(afterSort);
        long rank = 0;

        for(int i = 0; i < len; i++){
            if(!map.containsKey(afterSort[i])){
                map.put(afterSort[i], rank++);
            }
        }

        for(int i = 0; i< len; i++){
            if(i < len-1) {
                bw.write(map.get(beforeSort[i]) + " ");
            }else{
                bw.write(map.get(beforeSort[i]) + "");
            }
        }
        bw.flush();
    }
}
