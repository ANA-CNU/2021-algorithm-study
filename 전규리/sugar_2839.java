package boj;

import java.util.*;

public class sugar_2839 {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      int val = sc.nextInt();
      
      int v1 = 5;
      int v2 = 3;
      
      int len = 0;
      
      while (true) {
    	  if (val % v1 == 0) {
    	         len += val / v1;
    	         break;
    	  } else {
    		  val -= 3;
    		  len++;
         }
         if (val < 0) {
        	 len = -1;
        	 break;
         }
      }
      
      System.out.println(len);
   }
}