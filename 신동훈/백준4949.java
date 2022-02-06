
import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class 백준4949 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s;
        while(true){
            s=br.readLine();

            if(s.equals(".")){
                break;
            }

            else{
                Stack<String> stack =new Stack<>();
                String [] str =  s.split("");

                for(int i=0; i<str.length; i++){
                    String temp = str[i];
                    if(temp.equals(".")){
                        break;
                    }
                    if(temp.equals("[") || temp.equals("(")){
                        stack.push(temp);
                    }
                    else if(temp.equals("]")){
                        if(stack.isEmpty() || !stack.peek().equals("[")){
                            stack.push("]");
                            break;
                        }
                        else if(stack.peek().equals("[")){
                            stack.pop();
                        }
                    }
                    else if(temp.equals(")")){
                        if(stack.isEmpty()|| !stack.peek().equals("(")){
                            stack.push(")");
                            break;
                        }
                        else if(stack.peek().equals("(")){
                            stack.pop();
                        }
                    }
                }

                if(stack.isEmpty()){
                    System.out.println("yes");
                }else{
                    System.out.println("no");
                }
                stack.clear();
            }

        }

    }


}
