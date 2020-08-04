import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        s = s.trim();
        if (s.length() == 0) {
            System.out.println(0);
        }
        else {
            String[] res = s.split("[\\s!,?._'@]+");
            System.out.println(res.length);
            for (String a : res) {
                System.out.println(a);
            }
        }
        scan.close();
    }
}
