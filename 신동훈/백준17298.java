import java.io.*;
import java.util.Stack;

public class 백준17298 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N =Integer.parseInt(br.readLine());
        Stack<Integer> result = new Stack<>();
        Stack<Integer> tempStack = new Stack<>();
        String [] st = br.readLine().split(" ");




     for(int i=N-1; i>=0; i--) {
         int temp = Integer.parseInt(st[i]);

         while (!tempStack.isEmpty() && temp >= tempStack.peek()) {
             tempStack.pop();
         }
         //2가지 경우. 스택이 비었거나, temp 보다 임시 스택에 남아있는 값이 더 큰 경우
         if (tempStack.isEmpty()) {
             result.push(-1);//스택이 비었다는것은 이것보다 더 큰 수가 없다는 이야기이므로.
         } else {
             result.push(tempStack.peek());//???
         }
         tempStack.push(temp);

     }




         while(!result.isEmpty()){
             bw.write(result.pop()+" ");
         }
         bw.flush();


     }






}
