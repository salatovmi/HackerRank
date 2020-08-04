import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>(n);
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            list.add(a);
        }
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            String str = sc.next();
            if (str.equals("Insert")) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                list.add(x, y);
            }
            else if (str.equals("Delete")) {
                int x = sc.nextInt();
                list.remove(x);
            }
        }
        for (Integer r : list) {
            System.out.print(r + " ");
        }
    }
}
