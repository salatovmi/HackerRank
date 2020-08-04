import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            for (int x=0; x < n; x++) {
                int res = a;
                for (int z = 0; z <= x; z++) {
                    res += Math.pow(2, z) * b;
                }
                System.out.print(res + " ");
            }
            System.out.println();
        }
        in.close();
    }
}
