import java.io.*;
import java.util.Stack;

public class 백준1874 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N =Integer.parseInt(br.readLine());//숫자의 개수.

        int [] result = new int[N];//만들어야 할 순열

        for(int  i=0; i<N; i++){ //1~N까지 입력받는다
            result[i]=Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for(int  i=1; i<=N; i++){ //1~N까지 입력받는다

            stack.push(i);//집어넣었을 때
            sb.append("+\n");
            while (stack.peek()==result[count]){
                stack.pop();
                sb.append("-\n");
                count++;

                if(stack.isEmpty()){
                    break;
                }
            }

        }
        if(!stack.isEmpty()){
            System.out.println("NO");
        }else{
            System.out.print(sb);
        }

    }
}
