import java.io.*;
import java.util.Stack;

public class 백준17608 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack =new Stack<>();

        for(int i=0; i<N; i++){
            int temp = Integer.parseInt(br.readLine());

            while(!stack.isEmpty() && stack.peek()<=temp){
                stack.pop();
            }
            stack.push(temp);

        }
        System.out.println(stack.size());


    }
}
