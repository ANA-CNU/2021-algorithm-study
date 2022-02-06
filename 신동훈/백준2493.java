
import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class 백준2493 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N =Integer.parseInt(br.readLine());

        Stack<Tower> tower = new Stack<>();
        int [] matchCount = new int[N];
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        //StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i< N; i++){
            Tower temp = new Tower(arr[i],i+1);
            while(!tower.isEmpty()){
                if (tower.peek().high >= temp.high) {//왼쪽에 있는 타워(tower)가 오른에 있는 타워(temp) 보다 클 때 => 신호 전달!
                    //matchCount[i]=tower.peek().number;// i번째 타워의 신호를 받은 타워의 번호 저장, i는 0부터 시작이므로 i로 쓰는게 맞다
                    bw.write(tower.peek().number+" ");
                    break;
                }
                tower.pop();//오른쪽에 있는 타워가 더 크다면, 왼쪽에 있는 타워로는 절대 신호가 안 오므로 삭제
            }
            if(tower.isEmpty()) {
                bw.write("0 ");
            }
            tower.push(temp);
        }

/*        for (int i : matchCount) {
            bw.write(i+" ");
        }*/
        bw.flush();
    }

}

class Tower{
    int high;
    int number;
    public Tower(int high, int number){
        this.high=high;
        this.number=number;
    }
}
