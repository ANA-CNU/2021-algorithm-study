import java.io.*;
import java.util.Stack;

public class 백준10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N =Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num==0){
                stack.pop();
                continue;
            }
            stack.push(num);
        }

        int sum=0;
        while(!stack.isEmpty()){
            sum+=stack.pop();
        }
        bw.write(sum+"");
        bw.flush();
    }
}
