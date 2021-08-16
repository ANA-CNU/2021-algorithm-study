

import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws IOException {
        String[] data = br.readLine().split("");
        Stack <String> stack = new Stack<>();

        for(String s : data){
            stack.push(s);
        }

        int stick = 0;
        int answer = 0;

        while(!stack.isEmpty()){
            String t = stack.pop();
            if(t.equals(")")){
                if(stack.peek().equals("(")) {
                    // laser beam
                    answer += stick;
                    stack.pop();
                } else {
                    stick++;
                }
            } else {
                answer++;
                stick--;
            }
        }

        bw.write(answer + "");
        bw.flush();

    }
}

