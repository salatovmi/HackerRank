import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      System.out.println("================================");
      for(int i=0;i<3;i++) {
        String s1=sc.next();
        int x=sc.nextInt();
        System.out.print(s1);
        for (int a = 0; a < 15 - s1.length(); a++) {
          System.out.print(" ");
        }
        System.out.println(String.format("%03d", x));
      }
      System.out.println("================================");
    }
}
