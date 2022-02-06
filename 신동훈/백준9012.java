import java.io.*;
import java.util.Stack;

public class 백준9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N =Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();


        for(int i=0; i<N; i++){//바깥 for
            stack=new Stack<>();
            String[] str = br.readLine().split("");

            boolean OK =true;

            for(int j=0; j<str.length; j++){
                String input = str[j];

                if(input.equals("(")){
                    stack.push("(");
                }else{
                    if(stack.empty()){
                        OK=false;
                        //불가능
                    }else if(stack.peek().equals(")")){
                        OK=false;
                        //불가능
                    }else{
                        stack.pop();
                    }
                }
                if(!OK){
                    System.out.println("NO");
                    break;
                }
            }
            if(OK){

                    if (!stack.empty()) {
                        System.out.println("NO");
                    } else {
                        System.out.println("YES");
                    }

            }




        }//바깥 for

    }
}
