// BOJ 1071

import java.util.Scanner;

public class BOJ {
    static int[] num;
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        num = new int[1001];
        int[] next = new int[1001];
        for(int i=0; i<N; i++){
            num[sc.nextInt()]+=1;
        }
        int last = 0;
        for(int i=1000; i>=0; i--){
            if (num[i] == 0) continue;
            next[i]=last; last=i;
        }
        for(int i=0; i<1001; i++) {
            if (num[i] == 0) continue;
            if (i!=1000 && num[i+1]>0){
                if(next[i+1]!=0){
                    print(i); System.out.print(next[i+1] + " "); num[next[i+1]]-=1;
                }else{
                    print(i+1); print(i); return;
                }
            } else {
                print(i);
            }
        }
    }

    public static void print(int n){
        for(int i=0; i<num[n]; i++){
            System.out.print(n + " ");
        }
    }
}
